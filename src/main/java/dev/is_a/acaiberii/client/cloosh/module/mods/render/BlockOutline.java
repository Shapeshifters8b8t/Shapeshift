package dev.is_a.acaiberii.client.cloosh.module.mods.render;

import dev.is_a.acaiberii.client.cloosh.misc.util.RenderUtil;
import dev.is_a.acaiberii.client.cloosh.misc.util.Utils;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;

public class BlockOutline extends Module {
    public BlockOutline() {
        super("BlockOutline", Category.Render);
    }

    @SubscribeEvent
    public void onRender3d(RenderWorldLastEvent event) {
        RayTraceResult lookingAt = mc.objectMouseOver;
        if (lookingAt != null && lookingAt.typeOfHit == RayTraceResult.Type.BLOCK) {
            Color rainbow = new Color(Utils.getRGB(6, 1, 0.6f));
            IBlockState state = mc.world.getBlockState(lookingAt.getBlockPos());
            RenderUtil.drawBoxOutline(
                    state.getSelectedBoundingBox(mc.world, lookingAt.getBlockPos())
                            .offset(-mc.renderManager.renderPosX, -mc.renderManager.renderPosY, -mc.renderManager.renderPosZ),
                    rainbow.getRed() / 255f,
                    rainbow.getGreen() / 255f,
                    rainbow.getBlue() / 255f, 0.5f);
        }
    }
}
