package dev.is_a.acaiberii.client.cloosh.module.mods.movement;

import dev.is_a.acaiberii.client.cloosh.events.KeyPressEvent;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
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
