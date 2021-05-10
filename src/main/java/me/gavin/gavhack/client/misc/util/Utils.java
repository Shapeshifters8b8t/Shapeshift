package me.gavin.gavhack.client.misc.util;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.gavin.gavhack.BeriiOnToppe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.text.TextComponentString;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static Minecraft mc = Minecraft.getMinecraft();

    public static void printMSG(String message) {
        mc.player.sendMessage(new TextComponentString(ChatFormatting.RED + "[Gavhack] " + ChatFormatting.RESET + message));
    }

    public static void playClick() {
        mc.getSoundHandler().playSound(PositionedSoundRecord.getRecord(SoundEvents.UI_BUTTON_CLICK, 1.0F, 0.25F));
    }

    public static int getRGBWave(float seconds, float brightness, float saturation, long index) {
        float hue = ((System.currentTimeMillis() + index) % (int) (seconds * 1000)) / (seconds * 1000);
        return Color.HSBtoRGB(hue, saturation, brightness);
    }

    public static int getRGB(float seconds, float brightness, float saturation) {
        float hue = (System.currentTimeMillis() % (int) (seconds * 1000)) / (seconds * 1000);
        return Color.HSBtoRGB(hue, saturation, brightness);
    }

    // im a good coder
    public static List<BlockPos> getNearbyBlocks(EntityPlayer entityPlayer, int range, boolean motion) {
        List<BlockPos> nearbyBlocks = new ArrayList<>();

        if (motion) {
            entityPlayer.getPosition().add(new Vec3i(entityPlayer.motionX, entityPlayer.motionY, entityPlayer.motionZ));
        }

        for (int x = -range; x <= range; x++) {
            for (int y = -range; y <= range; y++) {
                for (int z = -range; z <= range; z++) {
                    nearbyBlocks.add(entityPlayer.getPosition().add(x, y, z));
                }
            }
        }

        return nearbyBlocks;
    }

    // thanks to bon for giving me the "chinese" method to having rainbow text
    // chat formatting codes do NOT work with this
    public static void drawRainbowFont(String text, int x, int y) {
        double xOffset = 0;
        char[] charArray = text.toCharArray();
        for (char c : charArray) {
            BeriiOnToppe.cfont.drawStringWithShadow(String.valueOf(c), x + xOffset, y, new Color(getRGBWave(10, 1, 0.6f, 35L * (long) xOffset)));
            xOffset += BeriiOnToppe.cfont.getStringWidth(String.valueOf(c)) + 0.275;
        }
    }

    public static void interpolateNametagPos(double x, double y, double z, double scale) {
        GlStateManager.translate(x - mc.renderManager.viewerPosX, y - mc.renderManager.viewerPosY, z - mc.renderManager.viewerPosZ);
        GlStateManager.rotate(-mc.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(mc.renderManager.playerViewX, mc.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f, 0.0f, 0.0f);
        GlStateManager.scale(-scale, -scale, scale);
    }
}