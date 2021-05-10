package dev.is_a.acaiberii.client.cloosh.module.mods.movement;

import dev.is_a.acaiberii.client.cloosh.events.LocalTickEvent;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoWalk extends Module {
    public AutoWalk() {
        super("AutoWalk", Category.Movement);
    }

    @SubscribeEvent
    public void onTick(LocalTickEvent event) {
        mc.gameSettings.keyBindForward.pressed = true;
    }

    public void onDisable() {
        mc.gameSettings.keyBindForward.pressed = false;
    }
}
