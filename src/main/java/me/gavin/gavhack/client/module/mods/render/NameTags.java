package me.gavin.gavhack.client.module.mods.render;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.gavhack.client.misc.util.RenderUtil;
import me.gavin.gavhack.client.misc.util.Utils;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.ModeSetting;
import me.gavin.gavhack.client.setting.impl.NumberSetting;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NameTags extends Module {

    //public BooleanSetting healthSetting = new BooleanSetting("Health", this, true);
    //public BooleanSetting distanceSetting = new BooleanSetting("Distance", this, false);
    public NumberSetting scaleSetting = new NumberSetting("Scale", this, 1.25, 0.5, 5, 0.25);
    public ModeSetting modeSetting = new ModeSetting("Mode", this, "Distance", "Distance", "Static");
    //public NumberSetting lineWidthSetting = new NumberSetting("LineWidth", this, 2.0, 1.0, 8.0, 0.5);

    public NameTags() {
        super("NameTags", Category.Render);
        addSettings(scaleSetting, modeSetting);

    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent event) {
        for (EntityPlayer player : mc.world.playerEntities) {
            if (player.equals(mc.player))
                continue;

            double x = MathHelper.clampedLerp(player.lastTickPosX, player.posX, event.getPartialTicks() - mc.renderManager.renderPosX);
            double y = MathHelper.clampedLerp(player.lastTickPosY, player.posY, event.getPartialTicks() - mc.renderManager.renderPosY);
            double z = MathHelper.clampedLerp(player.lastTickPosZ, player.posZ, event.getPartialTicks() - mc.renderManager.renderPosZ);

            renderNameTag(player, x, y, z, event.getPartialTicks());
        }
    }

    // thanks to A2H for nametag interpolation and rendering method
    private void renderNameTag(EntityPlayer player, double x, double y, double z, float partialTicks) {
        double tempY = y;
        tempY += player.isSneaking() ? 0.5 : 0.7;
        final Entity camera = mc.renderViewEntity;
        String displayTag = getNametagText(player);
        double distance = camera.getDistance(
                x - mc.renderManager.viewerPosX,
                y - mc.renderManager.viewerPosY,
                z - mc.renderManager.viewerPosZ
        );
        final double width = mc.fontRenderer.getStringWidth(displayTag) / 2F;

        double scale;
        if (modeSetting.is("Distance")) {
            scale = (0.0125 + (distance * 0.0035)) * (scaleSetting.getValue() / 10);
        } else {
            final double lastTickDistance = getDistance(new Vec3d(camera.lastTickPosX, camera.lastTickPosY, camera.lastTickPosZ), new Vec3d(player.lastTickPosX, player.lastTickPosY, player.lastTickPosZ));
            final double distance2 = MathHelper.clampedLerp(lastTickDistance, getDistance(camera.getPositionVector(), player.getPositionVector()), partialTicks);
            scale = (distance2) * (scaleSetting.getValue() / 100D);
        }

        RenderUtil.prepareGL();
        Utils.interpolateNametagPos(x, tempY + 1.4f, z, scale);
        GlStateManager.color(1, 1, 1, 1);
        Gui.drawRect((int) (-width - 2),(-(mc.fontRenderer.FONT_HEIGHT)), (int) width + 2, 1, 0x90000000);
        mc.fontRenderer.drawString(displayTag, (int)(-width), (-(mc.fontRenderer.FONT_HEIGHT - 1)), -1);
        RenderUtil.releaseGL();
    }

    private String getNametagText(EntityPlayer playerIn) {

        double health = playerIn.getHealth() + playerIn.getAbsorptionAmount();

        return  String.format(playerIn.getName() + " " + getHealthColor(health) + "%.1f", health);
    }

    private ChatFormatting getHealthColor(double health) {
        if (health >= 18) {
            return ChatFormatting.GREEN;
        } else if (health >= 14) {
            return ChatFormatting.YELLOW;
        } else if (health >= 10) {
            return ChatFormatting.GOLD;
        } else if (health >= 6) {
            return ChatFormatting.RED;
        } else {
            return ChatFormatting.DARK_RED;
        }
    }

    private double getDistance(Vec3d cp, Vec3d ep) {
        return Math.sqrt(Math.pow(ep.x - cp.x, 2.0D) + Math.pow(ep.y - cp.y, 2.0D) + Math.pow(ep.z - cp.z, 2.0D));
    }
}
