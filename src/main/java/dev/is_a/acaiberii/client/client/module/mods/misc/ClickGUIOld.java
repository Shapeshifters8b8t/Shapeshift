package dev.is_a.acaiberii.client.client.module.mods.misc;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.NumberSetting;
import org.lwjgl.input.Keyboard;

public class ClickGUIOld extends Module {
    public NumberSetting red = new NumberSetting("R", this, 94, 0, 255, 1);
    public NumberSetting green = new NumberSetting("G", this, 8, 0, 255, 1);
    public NumberSetting blue = new NumberSetting("B", this, 63, 0, 255, 1);

    public ClickGUIOld() {
        super("ClickGUIOld", Category.Misc);
        keyBind.setKeyCode(Keyboard.KEY_NONE);
        addSettings(red, green, blue);
    }

    public void onEnable() {
        mc.displayGuiScreen(BeriiOnToppe.gui);
    }
}
