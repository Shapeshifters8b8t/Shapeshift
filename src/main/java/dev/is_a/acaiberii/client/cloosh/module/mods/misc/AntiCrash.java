package dev.is_a.acaiberii.client.cloosh.module.mods.misc;

import dev.is_a.acaiberii.client.cloosh.events.PacketEvent;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
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