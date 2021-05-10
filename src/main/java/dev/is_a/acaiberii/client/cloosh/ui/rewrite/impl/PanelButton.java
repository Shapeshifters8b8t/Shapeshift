package dev.is_a.acaiberii.client.cloosh.ui.rewrite.impl;

import dev.is_a.acaiberii.client.cloosh.misc.util.FontUtil;
import dev.is_a.acaiberii.client.cloosh.ui.rewrite.api.button.AbstractButton;
import net.minecraft.client.gui.Gui;

public abstract class PanelButton extends AbstractButton {

    public String title;

    public PanelButton(int x, int y, int width, int height, String title) {
        super(x, y, width, height);
        this.title = title;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        Gui.drawRect(x, y, x + width, y + height, ClickGuiScreen.guiColor.getRGB());
        FontUtil.drawStringWithShadow(title, x + ((width / 2) - (FontUtil.getStringWidth(title) / 2)), y + (FontUtil.getHeight() / 2), -1);
    }

    @Override
    public abstract void handleClick(int mouseButton);
}
