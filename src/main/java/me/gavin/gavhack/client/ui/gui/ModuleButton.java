package me.gavin.gavhack.client.ui.gui;

import me.gavin.gavhack.BeriiOnToppe;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.Setting;
import me.gavin.gavhack.client.misc.util.FontUtil;
import me.gavin.gavhack.client.misc.util.Utils;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import me.gavin.gavhack.client.setting.impl.ModeSetting;
import me.gavin.gavhack.client.setting.impl.NumberSetting;
import me.gavin.gavhack.client.ui.gui.components.BooleanComponent;
import me.gavin.gavhack.client.ui.gui.components.KeybindComponent;
import me.gavin.gavhack.client.ui.gui.components.ModeComponent;
import me.gavin.gavhack.client.ui.gui.components.NumberComponent;
import net.minecraft.client.gui.Gui;

import java.util.ArrayList;

public class ModuleButton {

    public int x, y, width, height, offset;
    public Module module;
    public Panel panel;
    public boolean open;

    ArrayList<Component> settingComponents = new ArrayList<>();

    public ModuleButton(Module module, Panel parent, int x, int y, int width, int height, int offset) {
        this.module = module;
        this.panel = parent;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.offset = offset;

        // had to make it -14 because everything was 14 lower than it should be
        int settingOffset = -14;
        for (Setting s : module.settings) {
            if (s instanceof BooleanSetting) {
                settingComponents.add(new BooleanComponent(module, (BooleanSetting) s, x + width + 1, y + settingOffset, width, height, settingOffset));
            } else if (s instanceof ModeSetting) {
                settingComponents.add(new ModeComponent(module, (ModeSetting) s, x + width + 1, y + settingOffset, width , height, settingOffset));
            } else if (s instanceof NumberSetting) {
                settingComponents.add(new NumberComponent(module, (NumberSetting) s, x + width + 1, y + settingOffset, width, height, settingOffset));
            }

            settingOffset += 14;
        }

        settingComponents.add(new KeybindComponent(module, x + width + 1, y + settingOffset, width, height, settingOffset));
    }

    public void draw(int mouseX, int mouseY) {
        if (isMouseWithin(mouseX, mouseY)) {
            Gui.drawRect(x, y, x + width, y + height, 0xcfcccccc);
        } else {
            Gui.drawRect(x, y, x + width, y + height, 0xcf000000);
        }

        int color = -1;

        if (module.isEnabled()) {
            Gui.drawRect(x, y, x + 1, y + height, BeriiOnToppe.gui.guiColor.getRGB());
            color = BeriiOnToppe.gui.guiColor.getRGB();
        }

        FontUtil.drawStringWithShadow(module.getName(), x + 3, y + 3, color);

        String s;
        if (open) {
            s = "-";
        } else {
            s = "+";
        }

        FontUtil.drawStringWithShadow(s, x + width - 8, y + 3, color);

        if (open)
            settingComponents.forEach(component -> {
                component.setPos(x + width + 1, y + component.offset);
                component.draw(mouseX, mouseY);
            });
    }

    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        settingComponents.forEach(component -> component.mouseReleased(mouseX, mouseY, mouseButton));
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isMouseWithin(mouseX, mouseY)) {
            Utils.playClick();
            if (mouseButton == 0) {
                module.toggle();
            }

            if (mouseButton == 1) {
                if (!open) {
                    panel.buttons.forEach(moduleButton -> moduleButton.open = false);
                }
                open = !open;
            }
        }
        if (open)
            settingComponents.forEach(component -> component.mouseClicked(mouseX, mouseY, mouseButton));
    }

    public void keyTyped(char keyChar, int keyCode) {
        if (open)
            settingComponents.forEach(component -> component.keyTyped(keyChar, keyCode));
    }

    public Module getModule() {
        return module;
    }

    public boolean isMouseWithin(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}