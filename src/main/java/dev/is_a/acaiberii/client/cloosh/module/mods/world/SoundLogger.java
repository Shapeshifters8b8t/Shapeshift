package dev.is_a.acaiberii.client.cloosh.module.mods.world;

import dev.is_a.acaiberii.client.cloosh.events.PacketEvent;
import dev.is_a.acaiberii.client.cloosh.misc.util.Utils;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// currently broken,
// does not show actual sound position if it is out of range
public class SoundLogger extends Module {

    public SoundLogger() {
        super("ThunderHack", Category.World);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Receive event) {
        if (event.getPacket() instanceof SPacketSoundEffect) {
            SPacketSoundEffect packet = (SPacketSoundEffect) event.getPacket();
            if (packet.getSound() == SoundEvents.ENTITY_LIGHTNING_THUNDER)
                print(packet);
        }
    }

    private void print(SPacketSoundEffect packet) {
        Utils.printMSG("Lightning strike detected at XYZ: " + (int) packet.getX() + ", " + (int) packet.getY() + ", " + (int) packet.getZ());
    }
}