package dev.is_a.acaiberii.client.client.module.mods.movement;

import dev.is_a.acaiberii.client.client.events.LocalTickEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
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
