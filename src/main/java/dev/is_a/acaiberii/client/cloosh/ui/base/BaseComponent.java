package dev.is_a.acaiberii.client.cloosh.ui.base;

public abstract class BaseComponent implements IComponent {

    public int x, y, width, height, dragX, dragY;
    public boolean dragging;

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isMouseWithin(mouseX, mouseY)) {
            dragging = true;
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        dragging = false;
    }

    @Override
    public boolean isMouseWithin(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + height && mouseY > y && mouseY < y + height;
    }

    @Override
    public void updatePosition(int mouseX, int mouseY) {
        if (dragging) {
            this.x = (mouseX - dragX);
            this.y = (mouseY - dragY);
        }
    }

    @Override
    public abstract void draw(int mouseX, int mouseY);
}
