package me.gavin.gavhack.mixin.mixins;

import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu {

    @Inject(method = "drawScreen", at = @At("TAIL"))
    private void drawScreenHook(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        //Utils.drawRainbowFont(Gavhack.NAME + " " + Gavhack.VERSION, 2, 2);
        //Gavhack.cfont.drawStringWithShadow(Gavhack.NAME + " " + Gavhack.VERSION, 2, 2, new Color(0xff0000));
    }
}
