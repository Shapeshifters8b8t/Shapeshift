package dev.is_a.acaiberii.client.client.module.mods.world;

import dev.is_a.acaiberii.client.client.events.PacketEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import net.minecraft.network.play.server.SPacketPlayerPosLook;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoRotate extends Module {
    public NoRotate() {
        super("NoRotate", Category.World);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Receive event) {
        if (mc.player == null)
            return;

        if (event.getPacket() instanceof SPacketPlayerPosLook) {
            ((SPacketPlayerPosLook) event.getPacket()).pitch = mc.player.rotationPitch;
            ((SPacketPlayerPosLook) event.getPacket()).yaw = mc.player.rotationYaw;
        }
    }
}
