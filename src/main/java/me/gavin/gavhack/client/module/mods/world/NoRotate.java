package me.gavin.gavhack.client.module.mods.world;

import me.gavin.gavhack.client.events.PacketEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
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
