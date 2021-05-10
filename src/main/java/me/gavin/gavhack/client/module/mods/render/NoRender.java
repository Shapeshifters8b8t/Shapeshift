package me.gavin.gavhack.client.module.mods.render;

import me.gavin.gavhack.client.events.RenderEntityEvent;
import me.gavin.gavhack.client.events.RenderHurtcamEvent;
import me.gavin.gavhack.client.events.RenderOverlayEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityBat;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoRender extends Module {

    private BooleanSetting items = new BooleanSetting("Items", this, false);
    private BooleanSetting fallingBlocks = new BooleanSetting("FallingBlocks", this, true);
    private BooleanSetting bats = new BooleanSetting("Bats", this, true);
    private BooleanSetting hurtcam = new BooleanSetting("Hurtcam", this, true);
    private BooleanSetting bossbar = new BooleanSetting("Bossbar", this, true);
    private BooleanSetting pumpkin = new BooleanSetting("PumpkinOverlay", this, true);
    private BooleanSetting vignette = new BooleanSetting("Vignette", this, true);
    private BooleanSetting fire = new BooleanSetting("Fire", this, true);

    public NoRender() {
        super("NoRender", Category.Render);
        addSettings(items, bats, fallingBlocks, hurtcam, bossbar, pumpkin, vignette, fire);
    }

    @SubscribeEvent
    public void renderEntity(RenderEntityEvent event) {
        if (items.enabled && event.getEntity() instanceof EntityItem)
            event.setCanceled(true);

        if (bats.enabled && event.getEntity() instanceof EntityBat)
            event.setCanceled(true);

        if (fallingBlocks.enabled && event.getEntity() instanceof EntityFallingBlock)
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void onHurtcam(RenderHurtcamEvent event) {
        if (hurtcam.enabled)
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void onRender(RenderOverlayEvent event) {
        if (event.getType() == RenderOverlayEvent.OverlayType.Bossbar && bossbar.enabled)
            event.setCanceled(true);

        if (event.getType() == RenderOverlayEvent.OverlayType.Pumpkin && pumpkin.enabled)
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void onBlockOverlay(RenderBlockOverlayEvent event) {
        if (event.getOverlayType() == RenderBlockOverlayEvent.OverlayType.FIRE && fire.enabled)
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.VIGNETTE && vignette.enabled)
            event.setCanceled(true);
    }
}
