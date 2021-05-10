package me.gavin.gavhack.mixin.mixins;

import me.gavin.gavhack.client.events.RenderWeatherEvent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public class MixinWorld {

    @Inject(method = "getRainStrength", at = @At("HEAD"), cancellable = true)
    public void getRainHook(float delta, CallbackInfoReturnable<Float> cir) {
        RenderWeatherEvent event = new RenderWeatherEvent();
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()) {
            cir.setReturnValue(0f);
            cir.cancel();
        }
    }
}
