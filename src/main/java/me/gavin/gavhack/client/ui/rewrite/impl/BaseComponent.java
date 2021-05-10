package me.gavin.gavhack.client.ui.rewrite.impl;

import me.gavin.gavhack.client.ui.rewrite.api.component.AbstractComponent;

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
