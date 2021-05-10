package me.gavin.gavhack.mixin.mixins;

import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GuiScreen.class)
public class MixinGuiScreen {

    /*
    private final ResourceLocation MAP_BACKGROUND = new ResourceLocation("textures/map/map_background.png");

    Tooltips tooltips = (Tooltips) Gavhack.modManager.getMod("Tooltips");

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
            Minecraft.getMinecraft().entityRenderer.getMapItemRenderer().renderMap(data, true);
            GlStateManager.popMatrix();
        }
    }
     */
}
