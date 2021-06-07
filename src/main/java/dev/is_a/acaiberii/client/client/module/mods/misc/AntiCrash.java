package dev.is_a.acaiberii.client.client.module.mods.misc;

import dev.is_a.acaiberii.client.client.events.PacketEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import net.minecraft.network.play.server.SPacketParticles;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AntiCrash extends Module {
    public AntiCrash() {
        super("AntiCrash", Category.Misc);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketParticles && ((SPacketParticles) event.getPacket()).getParticleCount() > 1000) {
            event.setCanceled(true);
        }
    }
}