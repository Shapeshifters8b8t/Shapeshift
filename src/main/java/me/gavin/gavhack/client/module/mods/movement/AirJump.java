package me.gavin.gavhack.client.module.mods.movement;

import me.gavin.gavhack.client.events.KeyPressEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AirJump extends Module {
    public AirJump() {
        super("AirJump", Category.Movement);
    }

    @SubscribeEvent
    public void onKey(KeyPressEvent event) {
        if (mc.player == null)
            return;

        if (event.getKey() == mc.gameSettings.keyBindJump.getKeyCode()) {
            mc.player.jump();
        }
    }
}
