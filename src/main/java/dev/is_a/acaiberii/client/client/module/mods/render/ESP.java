package dev.is_a.acaiberii.client.client.module.mods.render;

import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ESP extends Module {
    public ESP() {
        super("ESP", Category.Render);
    }

    private ModeSetting mode = new ModeSetting("Mode", this, "Box", "Box", "Glow");

    @SubscribeEvent
    public void onRender3d(RenderWorldLastEvent event) {
        for (Entity e : mc.world.getLoadedEntityList()) {
            //AxisAlignedBB box = e.boundingBox.offset(- mc.renderManager.renderPosX, -mc.renderManager.renderPosY, -mc.renderManager.renderPosZ);
            //Color distanceColor = RenderUtil.getDistanceColor((int) mc.player.getDistance(e));
            //GlStateManager.pushMatrix();
            //RenderUtil.drawOutline(box, -distanceColor.getRed(), -distanceColor.getGreen(), -distanceColor.getBlue(), 120 / 255f);
            //GlStateManager.popMatrix();
        }
    }
}
