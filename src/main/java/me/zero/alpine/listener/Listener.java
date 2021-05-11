package me.zero.alpine.listener;

import broken.is.gradle.typetools.TypeResolver;
import me.zero.alpine.event.EventPriority;
import java.util.function.Predicate;

public class Listener<T> implements EventHook<T> {
    private final Class<T> target;
    private final EventHook<T> hook;
    private final Predicate<T>[] filters;
    private final int priority;
    @SafeVarargs
    public Listener(EventHook<T> hook, Predicate<T>... filters) {
        this(hook, EventPriority.DEFAULT, filters);
    }

    @SafeVarargs
    @SuppressWarnings("unchecked")
    public Listener(EventHook<T> hook, int priority, Predicate<T>... filters) {
        this.hook = hook;
        this.priority = priority;
        this.target = (Class<T>) TypeResolver.resolveRawArgument(EventHook.class, hook.getClass());
        this.filters = filters;
    }
    public Class<T> getTarget() {
        return this.target;
    } public int getPriority() {
        return priority;
    }
    @Override
    public void invoke(T event) {
        if (filters.length > 0) {
            for (Predicate<T> filter : filters) {
                if (!filter.test(event)) {
                    return;
                }
            }
        }
        this.hook.invoke(event);
    }
}
