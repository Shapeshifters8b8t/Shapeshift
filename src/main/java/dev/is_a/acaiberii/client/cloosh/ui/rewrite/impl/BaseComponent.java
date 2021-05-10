package dev.is_a.acaiberii.client.cloosh.ui.rewrite.impl;

import dev.is_a.acaiberii.client.cloosh.ui.rewrite.api.component.AbstractComponent;

public abstract class BaseComponent extends AbstractComponent {
    public BaseComponent(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public abstract void draw(int mouseX, int mouseY);
    @Override
    public abstract void mouseClicked(int mouseX, int mouseY, int mouseButton);

    @Override
    public abstract void mouseReleased(int mouseX, int mouseY, int mouseButton);

    protected void keyTyped(char keyChar, int keyCode) { }
}
