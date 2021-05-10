package me.gavin.gavhack.client.events;

import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class RenderOverlayEvent extends Event {

    public enum OverlayType {
        Bossbar,
        Pumpkin
    }

    private final OverlayType type;

    public RenderOverlayEvent(OverlayType type) {
        this.type = type;
    }

    public OverlayType getType() {
        return type;
    }
}
