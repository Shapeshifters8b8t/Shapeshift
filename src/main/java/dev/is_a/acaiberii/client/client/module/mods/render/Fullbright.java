package dev.is_a.acaiberii.client.client.module.mods.render;

import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;

public class Fullbright extends Module {

    public Fullbright() {
        super("Fullbright", Category.Render);
    }

    public void onEnable() {
        mc.gameSettings.gammaSetting = 100;
    }

    public void onDisable() {
        mc.gameSettings.gammaSetting = 1;
    }
}
