package dev.is_a.acaiberii.client.client.module.mods.world;

import dev.is_a.acaiberii.client.client.events.PacketEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.mixin.mixins.accessor.AccessorCPacketPlayerTryToUseItemOnBlock;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BuildHeight extends Module {
    public BuildHeight() {
        super("BuildHeight", Category.World);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketPlayerTryUseItemOnBlock) {
            CPacketPlayerTryUseItemOnBlock packet = (CPacketPlayerTryUseItemOnBlock) event.getPacket();

            if (packet.getPos().getY() >= 255
                    && ((AccessorCPacketPlayerTryToUseItemOnBlock) packet).getPlacedBlockDirection() == EnumFacing.UP) {
                ((AccessorCPacketPlayerTryToUseItemOnBlock) packet).setPlacedBlockDirection(EnumFacing.DOWN);
            }
        }
    }
}
