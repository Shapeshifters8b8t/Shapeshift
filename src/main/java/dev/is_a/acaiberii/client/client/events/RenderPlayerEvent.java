package dev.is_a.acaiberii.client.client.events;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;

public class RenderPlayerEvent extends Event {
    private final AbstractClientPlayer entity;
    private final double x;
    private final double y;
    private final double z;

    public RenderPlayerEvent(AbstractClientPlayer entity, double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.entity = entity;
    }

    public AbstractClientPlayer getEntity() { return this.entity; }

    public double getX() { return this.x; }

    public double getY() { return this.y; }

    public double getZ() { return this.z; }
}
