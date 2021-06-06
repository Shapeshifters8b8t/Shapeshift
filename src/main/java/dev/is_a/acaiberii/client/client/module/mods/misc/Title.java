package dev.is_a.acaiberii.client.client.module.mods.misc;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.events.ModeSettingChangedEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.Display;

public class Title extends Module {
    public ModeSetting titleMode = new ModeSetting("Mode", this, "Shapeshift", "Shapeshift", "Ghost");

    public Title() { super("Title", Category.Misc); this.settings.add(titleMode); }

    @SubscribeEvent
    public void onModeSettingChanged(ModeSettingChangedEvent event) {
        if (event.getSetting() == titleMode) {
            switch (event.getMode()) {
                case "Shapeshift":
                    Display.setTitle("Shapeshift " + BeriiOnToppe.VERSION);
                case "Ghost":
                    Display.setTitle("Minecraft 1.12.2");
            }
        }
    }
}
