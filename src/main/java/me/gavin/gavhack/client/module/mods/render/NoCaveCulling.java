package me.gavin.gavhack.client.module.mods.render;

import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;

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
