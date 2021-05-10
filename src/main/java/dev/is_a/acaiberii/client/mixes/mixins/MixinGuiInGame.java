package dev.is_a.acaiberii.client.mixes.mixins;

import dev.is_a.acaiberii.client.cloosh.events.RenderOverlayEvent;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class MixinGuiInGame {

    @Inject(method = "renderPumpkinOverlay", at = @At("HEAD"), cancellable = true)
    private void renderPumpkinPatch(ScaledResolution scaledRes, CallbackInfo ci) {
        RenderOverlayEvent event = new RenderOverlayEvent(RenderOverlayEvent.OverlayType.Pumpkin);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
            ci.cancel();
    }
}
