package me.gavin.gavhack.client.module.mods.misc;

import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
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
