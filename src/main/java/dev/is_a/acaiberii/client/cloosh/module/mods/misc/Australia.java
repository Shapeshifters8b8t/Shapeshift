package dev.is_a.acaiberii.client.cloosh.module.mods.misc;

import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import net.minecraft.util.ResourceLocation;

// from Xulu
public class Australia extends Module {
    public Australia() {
        super("Australia", Category.Misc);
    }

    @Override
    public void onEnable() {
        mc.entityRenderer.loadShader(new ResourceLocation("shaders/post/flip.json"));
    }

    @Override
    public void onDisable() {
        mc.entityRenderer.getShaderGroup().deleteShaderGroup();
    }
}
