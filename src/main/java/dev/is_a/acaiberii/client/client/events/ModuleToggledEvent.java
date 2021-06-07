package dev.is_a.acaiberii.client.client.events;

import dev.is_a.acaiberii.client.client.module.Module;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ModuleToggledEvent extends Event {
    private final Module mod;

    public ModuleToggledEvent(Module mod) {
        this.mod = mod;
    }

    public Module getMod() { return this.mod; }
}
