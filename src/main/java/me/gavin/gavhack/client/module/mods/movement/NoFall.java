package me.gavin.gavhack.client.module.mods.movement;

import me.gavin.gavhack.client.events.LocalTickEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
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
