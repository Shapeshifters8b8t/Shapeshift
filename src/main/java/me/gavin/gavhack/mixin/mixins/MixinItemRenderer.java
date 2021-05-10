package me.gavin.gavhack.mixin.mixins;

import me.gavin.gavhack.client.events.RenderPlayerHandEvent;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.util.EnumHandSide;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


// mixin from postman because i have no idea how to make a viewmodel
@Mixin(ItemRenderer.class)
public class MixinItemRenderer {

    @Inject(method = "transformSideFirstPerson", at = @At("HEAD"))
    public void transformSideFirstPersonPatch(EnumHandSide hand, float p_187459_2_, CallbackInfo ci) {
        MinecraftForge.EVENT_BUS.post(new RenderPlayerHandEvent(hand));
    }

    @Inject(method = "transformFirstPerson", at = @At("HEAD"))
    public void transformFirstPersonPatch(EnumHandSide hand, float p_187453_2_, CallbackInfo ci) {
        MinecraftForge.EVENT_BUS.post(new RenderPlayerHandEvent(hand));
    }
}
