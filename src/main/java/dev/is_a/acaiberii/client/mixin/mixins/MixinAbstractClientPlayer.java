package dev.is_a.acaiberii.client.mixin.mixins;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.Objects;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayer {

    @Shadow @Nullable protected abstract NetworkPlayerInfo getPlayerInfo();

    @Inject(method = "getLocationCape", at = @At("HEAD"), cancellable = true)
    private void getCapeHook(CallbackInfoReturnable<ResourceLocation> cir) {
        if (BeriiOnToppe.capeUtil.hasCape(Objects.requireNonNull(getPlayerInfo()).getGameProfile().getId())) {
            cir.setReturnValue(new ResourceLocation("gavhack:cape.png"));
        }
    }
}