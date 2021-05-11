package dev.is_a.acaiberii.client.client.module.mods.misc;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.BooleanSetting;
import dev.is_a.acaiberii.client.client.setting.impl.NumberSetting;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", Category.Misc);
        keyBind.setKeyCode(Keyboard.KEY_RCONTROL);
        redValue = new NumberSetting("R", this, 94, 0, 255, 1);
        greenValue = new NumberSetting("G", this, 8, 0, 255, 1);
        blueValue = new NumberSetting("B", this, 63, 0, 255, 1);
        addSettings(redValue, blueValue, greenValue);
    }

    public static NumberSetting redValue, blueValue, greenValue, rainbowSpeed;
    public static BooleanSetting rainbowSetting;

    public void onEnable() {
        mc.displayGuiScreen(BeriiOnToppe.clickGui);
    }
}
