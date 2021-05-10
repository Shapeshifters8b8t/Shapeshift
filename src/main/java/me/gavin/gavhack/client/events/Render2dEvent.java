package me.gavin.gavhack.client.events;

import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.fml.common.eventhandler.Event;

public class Render2dEvent extends Event {
    private final ScaledResolution sr;

    public Render2dEvent(ScaledResolution sr) {
        this.sr = sr;
    }

    public ScaledResolution getScaledRes() {
        return this.sr;
    }
}