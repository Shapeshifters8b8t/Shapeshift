package dev.is_a.acaiberii.client.mixes.mixins;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderPlayer.class)
public class MixinRenderPlayer {

    @Inject(method = "renderEntityName", at = @At("HEAD"), cancellable = true)
    public void onRenderEntityNamePatch(AbstractClientPlayer entityIn, double x, double y, double z, String name, double distanceSq, CallbackInfo ci) {
        if (BeriiOnToppe.modManager.getMod("NameTags").isEnabled())
            ci.cancel();
    }
}
