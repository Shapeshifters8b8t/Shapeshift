package dev.is_a.acaiberii.client.cloosh.module.mods.misc;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import dev.is_a.acaiberii.client.cloosh.setting.impl.BooleanSetting;
import dev.is_a.acaiberii.client.cloosh.setting.impl.NumberSetting;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", Category.Misc);
        keyBind.setKeyCode(Keyboard.KEY_RCONTROL);
        redValue = new NumberSetting("R", this, 255, 0, 255, 1);
        greenValue = new NumberSetting("G", this, 0, 0, 255, 1);
        blueValue = new NumberSetting("B", this, 0, 0, 255, 1);
        addSettings(redValue, blueValue, greenValue);
    }

    public static NumberSetting redValue, blueValue, greenValue, rainbowSpeed;
    public static BooleanSetting rainbowSetting;

    public void onEnable() {
        mc.displayGuiScreen(BeriiOnToppe.clickGui);
    }
}
