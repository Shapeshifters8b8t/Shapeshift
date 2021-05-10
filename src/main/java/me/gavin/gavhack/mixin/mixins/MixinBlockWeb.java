package me.gavin.gavhack.mixin.mixins;

import me.gavin.gavhack.BeriiOnToppe;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import net.minecraft.block.BlockWeb;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockWeb.class)
public class MixinBlockWeb {

    @Inject(method = "onEntityCollidedWithBlock", at = @At("HEAD"), cancellable = true)
    public void cobwebCollisionPatch(World worldIn, BlockPos pos, IBlockState state, Entity entityIn, CallbackInfo ci) {
        if (entityIn == Minecraft.getMinecraft().player) {
            if (BeriiOnToppe.modManager.getMod("NoSlow").isEnabled()
                    && ((BooleanSetting)(BeriiOnToppe.modManager.getMod("NoSlow").getSetting("Cobwebs"))).enabled) {
                ci.cancel();
            }
        }
    }
}
