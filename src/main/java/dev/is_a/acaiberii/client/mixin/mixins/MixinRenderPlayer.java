package dev.is_a.acaiberii.client.mixin.mixins;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.events.RenderPlayerEvent;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraftforge.common.MinecraftForge;
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

    @Inject(method = "doRender", at = @At("HEAD"), cancellable = false)
    public void onRenderPlayer(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks) {
        RenderPlayerEvent event = new RenderPlayerEvent(entity, x, y, z);
        MinecraftForge.EVENT_BUS.post(event);
    }
}
