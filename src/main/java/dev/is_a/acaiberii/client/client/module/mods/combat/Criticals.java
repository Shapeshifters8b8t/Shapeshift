package dev.is_a.acaiberii.client.client.module.mods.combat;

import dev.is_a.acaiberii.client.client.events.PacketEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketUseEntity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Criticals extends Module {

    public ModeSetting attackMode = new ModeSetting("Mode", this, "Packet", "Packet", "Jump");

    public Criticals() {
        super("Criticals", Category.Combat);
        addSettings(attackMode);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketUseEntity) {
            CPacketUseEntity packet = (CPacketUseEntity) event.getPacket();

            if (attackMode.is("Packet")) {
                if (packet.getAction() == CPacketUseEntity.Action.ATTACK && mc.player.onGround) {
                    mc.getConnection().sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.1f, mc.player.posZ, false));
                    mc.getConnection().sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY, mc.player.posZ, false));
                }
            } else {
                if (mc.player.onGround)
                    mc.player.jump();
            }
        }
    }
}