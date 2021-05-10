package me.gavin.gavhack.client.module.mods.movement;

import me.gavin.gavhack.client.events.LocalTickEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
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
