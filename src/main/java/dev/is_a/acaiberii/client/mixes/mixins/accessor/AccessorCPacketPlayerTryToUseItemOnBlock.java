package dev.is_a.acaiberii.client.mixes.mixins.accessor;

import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CPacketPlayerTryUseItemOnBlock.class)
public interface AccessorCPacketPlayerTryToUseItemOnBlock {

    @Accessor("placedBlockDirection")
    public EnumFacing getPlacedBlockDirection();

    @Accessor("placedBlockDirection")
    public void setPlacedBlockDirection(EnumFacing facing);
}
