package me.gavin.gavhack.client.module.mods.misc;

import me.gavin.gavhack.BeriiOnToppe;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;

public class HudEditor extends Module {
    public HudEditor() {
        super("HudEditor", Category.Misc);
    }

    public void onEnable() {
        mc.displayGuiScreen(BeriiOnToppe.hudEditor);
    }
}
