package dev.is_a.acaiberii.client.client.module.mods.movement;

import dev.is_a.acaiberii.client.client.events.LocalTickEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", Category.Movement);
    }

    @SubscribeEvent
    public void onTick(LocalTickEvent event) {
        if (mc.player.moveForward > 0 && !mc.player.collidedHorizontally)
            mc.player.setSprinting(true);
    }
}
