package me.zero.alpine.bus;

import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listenable;
import me.zero.alpine.listener.Listener;
import me.zero.alpine.event.EventPriority;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
public class EventManager implements EventBus {
    private final Map<Listenable, List<Listener>> SUBSCRIPTION_CACHE = new ConcurrentHashMap<>();
    private final Map<Class<?>, List<Listener>> SUBSCRIPTION_MAP = new ConcurrentHashMap<>();

    @Override
    public void subscribe(Listenable listenable) {
        List<Listener> listeners = SUBSCRIPTION_CACHE.computeIfAbsent(listenable, o ->
                Arrays.stream(o.getClass().getDeclaredFields())
                        .filter(EventManager::isValidField)
                        .map(field -> asListener(o, field))
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList()));

        listeners.forEach(this::subscribe);
    }

    @Override
    public void subscribe(Listener listener) {
        List<Listener> listeners = SUBSCRIPTION_MAP.computeIfAbsent(listener.getTarget(), target -> new CopyOnWriteArrayList<>());

        int index = 0;
        for (; index < listeners.size(); index++) {
            if (listener.getPriority() > listeners.get(index).getPriority()) {
                break;
            }
        }

        listeners.add(index, listener);
    }

    @Override
    public void unsubscribe(Listenable listenable) {
        List<Listener> objectListeners = SUBSCRIPTION_CACHE.get(listenable);
        if (objectListeners == null)
            return;

        SUBSCRIPTION_MAP.values().forEach(listeners -> listeners.removeIf(objectListeners::contains));
    }

    @Override
    public void unsubscribe(Listener listener) {
        SUBSCRIPTION_MAP.get(listener.getTarget()).removeIf(l -> l.equals(listener));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void post(Object event) {
        List<Listener> listeners = SUBSCRIPTION_MAP.get(event.getClass());
        if (listeners != null)
            listeners.forEach(listener -> listener.invoke(event));
    }
    private static boolean isValidField(Field field) {
        return field.isAnnotationPresent(EventHandler.class) && Listener.class.isAssignableFrom(field.getType());
    }
    private static Listener asListener(Listenable listenable, Field field) {
        try {
            boolean accessible = field.isAccessible();
            field.setAccessible(true);
            Listener listener = (Listener) field.get(listenable);
            field.setAccessible(accessible);

            if (listener == null)
                return null;

            return listener;
        } catch (IllegalAccessException e) {
            return null;
        }
    }
}
