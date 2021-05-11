package dev.is_a.acaiberii.client.client.ui.base;

public interface IComponent {

    void mouseClicked(int mouseX, int mouseY, int mouseButton);

    void mouseReleased(int mouseX, int mouseY, int mouseButton);

    void updatePosition(int mouseX, int mouseY);

    void draw(int mouseX, int mouseY);

    boolean isMouseWithin(int mouseX, int mouseY);
}
