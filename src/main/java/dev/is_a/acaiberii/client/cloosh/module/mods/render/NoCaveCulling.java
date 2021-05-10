package dev.is_a.acaiberii.client.cloosh.module.mods.render;

import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;

public class NoCaveCulling extends Module {
    public NoCaveCulling() {
        super("NoCaveCulling", Category.Render);
    }

    public static boolean stopCaveCulling;

    public void onEnable() {
        stopCaveCulling = true;

        if (mc.world == null)
            return;

        mc.renderGlobal.loadRenderers();
    }

    public void onDisable() {
        stopCaveCulling = false;

        if (mc.world == null)
            return;

        mc.renderGlobal.loadRenderers();
    }
}
