package dev.is_a.acaiberii.client.client.module.mods.movement;

import dev.is_a.acaiberii.client.client.events.LocalTickEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoFall extends Module {
    public NoFall() {
        super("NoFall", Category.Movement);
    }

    @SubscribeEvent
    public void onTick(LocalTickEvent event) {
        if (mc.player.fallDistance > 5.0F) {
            mc.player.capabilities.isFlying = true;
            mc.getConnection().sendPacket(new CPacketPlayer(true));
            mc.player.velocityChanged = true;
            mc.player.capabilities.isFlying = false;
        }
    }
}
