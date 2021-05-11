package dev.is_a.acaiberii.client.client.module.mods.misc;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;

public class HudEditor extends Module {
    public HudEditor() {
        super("HudEditor", Category.Misc);
    }

    public void onEnable() {
        mc.displayGuiScreen(BeriiOnToppe.hudEditor);
    }
}
