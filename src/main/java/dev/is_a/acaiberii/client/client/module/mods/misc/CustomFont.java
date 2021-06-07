package dev.is_a.acaiberii.client.client.module.mods.misc;

import dev.is_a.acaiberii.client.client.misc.util.FontUtil;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;

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
