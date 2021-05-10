package me.gavin.gavhack.client.module.mods.movement;

import me.gavin.gavhack.client.events.LocalTickEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
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
