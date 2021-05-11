package dev.is_a.acaiberii.client.client.ui.rewrite.impl.setting;

import dev.is_a.acaiberii.client.client.misc.util.FontUtil;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import dev.is_a.acaiberii.client.client.ui.rewrite.impl.BaseComponent;

public class ModeComponent extends BaseComponent {

    public ModeSetting parent;

    public ModeComponent(ModeSetting parent, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.parent = parent;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        FontUtil.drawStringWithShadow(parent.name + ": " + parent.getMode(),x + 3, y + 2, -1);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isMouseWithin(mouseX, mouseY) && mouseButton == 0)
            parent.cycle();
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {

    }
}