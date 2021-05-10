package dev.is_a.acaiberii.client.cloosh.module.mods.misc;

import dev.is_a.acaiberii.client.cloosh.misc.util.FontUtil;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;

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
