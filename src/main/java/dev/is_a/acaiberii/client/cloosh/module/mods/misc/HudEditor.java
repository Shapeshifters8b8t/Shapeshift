package dev.is_a.acaiberii.client.cloosh.module.mods.misc;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;

public class HudEditor extends Module {
    public HudEditor() {
        super("HudEditor", Category.Misc);
    }

    public void onEnable() {
        mc.displayGuiScreen(BeriiOnToppe.hudEditor);
    }
}
