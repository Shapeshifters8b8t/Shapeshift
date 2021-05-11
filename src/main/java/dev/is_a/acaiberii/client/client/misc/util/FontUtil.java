package dev.is_a.acaiberii.client.client.misc.util;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import net.minecraft.client.Minecraft;

import java.awt.*;

public class FontUtil {

    public static boolean doCustomFont = false;

    public static void drawString(String text, float x, float y, int color) {
        if (doCustomFont) {
            BeriiOnToppe.cfont.drawString(text, x, y, new Color(color));
        } else {
            Minecraft.getMinecraft().fontRenderer.drawString(text, x, y, color, false);
        }
    }

    public static void drawStringWithShadow(String text, float x, float y, int color) {
        if (doCustomFont) {
            BeriiOnToppe.cfont.drawStringWithShadow(text, x, y, new Color(color));
        } else {
            Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(text, x, y, color);
        }
    }

    public static int getStringWidth(String text) {
        if (doCustomFont) {
            return BeriiOnToppe.cfont.getStringWidth(text);
        } else {
            return Minecraft.getMinecraft().fontRenderer.getStringWidth(text);
        }
    }

    public static int getHeight() {
        if (doCustomFont) {
            return BeriiOnToppe.cfont.getHeight();
        } else {
            return Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT;
        }
    }
}
