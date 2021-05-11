package dev.is_a.acaiberii.client.client.ui.rewrite.impl.setting;

import dev.is_a.acaiberii.client.client.misc.util.FontUtil;
import dev.is_a.acaiberii.client.client.setting.impl.BooleanSetting;
import dev.is_a.acaiberii.client.client.ui.rewrite.impl.BaseComponent;
import dev.is_a.acaiberii.client.client.ui.rewrite.impl.ClickGuiScreen;
import net.minecraft.client.gui.Gui;

public class BooleanComponent extends BaseComponent {

    public BooleanSetting parent;
    public BooleanComponent(BooleanSetting parent, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.parent = parent;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        if (parent.enabled) {
            Gui.drawRect(x, y, x + width, y + height, ClickGuiScreen.guiColor.getRGB());
        }

        FontUtil.drawStringWithShadow(parent.name, x + 3, y + 2, -1);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isMouseWithin(mouseX, mouseY) && mouseButton == 0)
            parent.enabled = !parent.enabled;
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {}
}
