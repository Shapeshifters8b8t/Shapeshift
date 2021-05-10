package dev.is_a.acaiberii.client.cloosh.ui.rewrite.api.component;

import dev.is_a.acaiberii.client.cloosh.ui.rewrite.api.IComponent;

public abstract class AbstractComponent implements IComponent {

    public int x, y, width, height;

    public AbstractComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public abstract void draw(int mouseX, int mouseY);

    @Override
    public abstract void mouseClicked(int mouseX, int mouseY, int mouseButton);

    @Override
    public abstract void mouseReleased(int mouseX, int mouseY, int mouseButton);

    @Override
    public boolean isMouseWithin(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }
}
