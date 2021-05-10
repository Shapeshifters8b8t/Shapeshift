package me.gavin.gavhack.mixin.mixins;

import me.gavin.gavhack.client.module.mods.render.XRay;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class MixinBlock {

    @Inject(method = "shouldSideBeRendered", at = @At("HEAD"), cancellable = true)
    public void renderBlockPatch(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side, CallbackInfoReturnable<Boolean> cir) {
        if (XRay.doXray) {
            if (XRay.xrayBlocks.contains(blockState.getBlock())) {
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
    }

    @Inject(method = "isFullCube", at = @At("HEAD"), cancellable = true)
    public void isFullCubePatch(IBlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (XRay.doXray) {
            cir.setReturnValue(XRay.xrayBlocks.contains(state.getBlock()));
        }
    }
}
