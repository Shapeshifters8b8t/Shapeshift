package dev.is_a.acaiberii.client.cloosh.misc.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import static org.lwjgl.opengl.GL11.*;

import java.awt.*;

public class RenderUtil {
    protected static Minecraft mc = Minecraft.getMinecraft();

    public static void prepareGL() {
        GlStateManager.pushMatrix();
        GlStateManager.enableBlend();
        GlStateManager.disableDepth();
        GlStateManager.disableCull();
        // le skid
        GlStateManager.tryBlendFuncSeparate(770, 771, 0, 1);
        GlStateManager.disableTexture2D();
        GlStateManager.depthMask(false);

        glLineWidth(1.0F);
        glEnable(GL_LINE_SMOOTH);
        glHint(GL_LINE_SMOOTH_HINT, GL_NICEST);
    }

    public static void releaseGL() {
        glDisable(GL_LINE_SMOOTH);

        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.enableDepth();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    public static AxisAlignedBB generateBB(long x, long y, long z) {
        BlockPos blockPos = new BlockPos(x, y, z);
        final AxisAlignedBB bb = new AxisAlignedBB
                (
                        blockPos.getX() - mc.getRenderManager().viewerPosX,
                        blockPos.getY() - mc.getRenderManager().viewerPosY,
                        blockPos.getZ() - mc.getRenderManager().viewerPosZ,
                        blockPos.getX() + 1 - mc.getRenderManager().viewerPosX,
                        blockPos.getY() + (1) - mc.getRenderManager().viewerPosY,
                        blockPos.getZ() + 1 - mc.getRenderManager().viewerPosZ
                );
        return bb;
    }

    public static void drawBox(AxisAlignedBB bb, float r, float g, float b, float a) {
        prepareGL();
        RenderGlobal.renderFilledBox(bb, r, g, b, a);
        releaseGL();
    }

    public static void drawBoxOutline(AxisAlignedBB bb, float r, float g, float b, float a) {
        prepareGL();
        GlStateManager.color(r , g, b, a);
        RenderGlobal.renderFilledBox(bb, r, g, b, a);
        RenderGlobal.drawSelectionBoundingBox(bb, r, g, b, a * 1.5F);
        releaseGL();
    }

    public static void drawOutline(AxisAlignedBB bb, float r, float g, float b, float a) {
        prepareGL();
        RenderGlobal.drawSelectionBoundingBox(bb, r, g, b, a * 1.5F);
        releaseGL();
    }

    public static Color getDistanceColor(int distance) {
        if (distance > 50) {
            distance = 50;
        }

        int red = (int) (255 - (distance * 5.1));
        int green = 255 - red;

        return new Color(red, green, 0, 255);
    }

    // thank you max!
    public static void drawLine(float x1, float y1, float x2, float y2, Color color) {
        GlStateManager.color(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, color.getAlpha() / 255F);
        glLineWidth(2.0F);
        glDisable(GL_TEXTURE_2D);
        glBegin(GL_LINES);
        glVertex2f(x1, y1);
        glVertex2f(x2, y2);
        glEnd();
        glEnable(GL_TEXTURE_2D);
    }

    public static void drawOutlineRect(float x, float y, float width, float height, Color color, float lineWidth) {
        GlStateManager.color(color.getRed() / 255F, color.getGreen() / 255F, color.getBlue() / 255F, color.getAlpha() / 255F);
        glLineWidth(lineWidth);
        glDisable(GL_TEXTURE_2D);
        glBegin(GL_LINE_LOOP);
        glVertex2f(x, y);
        glVertex2f(x + width, y);
        glVertex2f(x + width, y + height);
        glVertex2f(x, y + height);
        glEnd();
        glEnable(GL_TEXTURE_2D);
    }

    public static void drawFilledOutlineRect(int x, int y, int width, int height, int color, int lineColor, float lineWidth) {
        Gui.drawRect(x, y ,x + width, y + height, color);
        drawOutlineRect(x, y, width, height, new Color(lineColor), lineWidth);
    }
}