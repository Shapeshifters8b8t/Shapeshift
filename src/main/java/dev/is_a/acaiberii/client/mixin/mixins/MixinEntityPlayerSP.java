package dev.is_a.acaiberii.client.mixin.mixins;

import dev.is_a.acaiberii.client.client.events.PlayerMoveEvent;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.MoverType;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {

    @Inject(method = "move", at = @At("HEAD"), cancellable = true)
    public void playerMovePatch(MoverType type, double x, double y, double z, CallbackInfo ci) {
        PlayerMoveEvent event = new PlayerMoveEvent(x, y, z);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
            ci.cancel();

        x = event.getX();
        y = event.getY();
        z = event.getZ();
    }
}
