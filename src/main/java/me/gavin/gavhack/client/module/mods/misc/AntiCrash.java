package me.gavin.gavhack.client.module.mods.misc;

import me.gavin.gavhack.client.events.PacketEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
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