package me.gavin.gavhack.client.module.mods.misc;

import me.gavin.gavhack.client.misc.util.FontUtil;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;

public class CustomFont extends Module {
    public CustomFont() {
        super("CustomFont", Category.Misc);
    }

    public void onEnable() {
        FontUtil.doCustomFont = true;
    }

    public void onDisable() {
        FontUtil.doCustomFont = false;
    }
}
