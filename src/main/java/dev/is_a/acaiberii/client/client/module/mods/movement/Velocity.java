package dev.is_a.acaiberii.client.client.module.mods.movement;

import dev.is_a.acaiberii.client.client.events.PacketEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import net.minecraft.network.play.server.SPacketEntityVelocity;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Velocity extends Module {
    public Velocity() {
        super("Velocity", Category.Movement);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketExplosion)
            event.setCanceled(true);

        if (event.getPacket() instanceof SPacketEntityVelocity) {
            if (((SPacketEntityVelocity) event.getPacket()).getEntityID() == mc.player.getEntityId())
                event.setCanceled(true);
        }
    }
}
