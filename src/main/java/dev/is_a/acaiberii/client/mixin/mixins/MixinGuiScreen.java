package dev.is_a.acaiberii.client.mixin.mixins;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.module.mods.misc.Tooltips;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemMap;
import net.minecraft.item.ItemShulkerBox;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.MapData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(GuiScreen.class)
public class MixinGuiScreen {
    private final ResourceLocation MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");

    Tooltips tooltips = (Tooltips) BeriiOnToppe.modManager.getMod("Tooltips");

    @Inject(method = "renderToolTip", at = @At("HEAD"), cancellable = true)
    public void renderToolTipPatch(ItemStack stack, int x, int y, CallbackInfo ci) {
        if (stack.isEmpty())
            return;

        if (stack.getItem() instanceof ItemShulkerBox && tooltips.isEnabled()) {
            ci.cancel();
        }

        if (stack.getItem() instanceof ItemMap && tooltips.isEnabled()) {
            MapData data = ((ItemMap)stack.getItem()).getMapData(stack, Minecraft.getMinecraft().world);
            GlStateManager.pushMatrix();
            GlStateManager.disableLighting();
            GlStateManager.translate(x + 8, y - 85, 300f);
            GlStateManager.scale(0.5, 0.5, 0.5);
            GlStateManager.color(1, 1, 1, 1);
            Minecraft.getMinecraft().entityRenderer.getMapItemRenderer().renderMap(Objects.requireNonNull(data), true);
            GlStateManager.popMatrix();
        }
    }
}
