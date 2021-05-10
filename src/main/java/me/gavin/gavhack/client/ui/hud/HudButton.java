package me.gavin.gavhack.client.ui.hud;

public class HudButton {

    public int x, y, width, height;
    public HudComponent parent;

    public HudButton(HudComponent component, int x, int y, int width, int height) {
        this.parent = component;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {

    }

    public void draw(int mouseX, int mouseY) {

    }
}
