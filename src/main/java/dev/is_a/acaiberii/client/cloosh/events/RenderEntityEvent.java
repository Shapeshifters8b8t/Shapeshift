package dev.is_a.acaiberii.client.cloosh.events;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class RenderEntityEvent extends Event {

    private final Entity entity;
    private Type type;

    public RenderEntityEvent(Entity entity, Type type) {
        this.entity = entity;
        this.type = type;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public void setType(Type typeIn) {
        this.type = typeIn;
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        PRE,
        POST
    }
}
