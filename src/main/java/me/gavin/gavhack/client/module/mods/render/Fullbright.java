package me.gavin.gavhack.client.module.mods.render;

import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;

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
