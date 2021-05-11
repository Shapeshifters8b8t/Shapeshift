package dev.is_a.acaiberii.client.client.ui.rewrite.api;

public interface IComponent {

    void draw(int mouseX, int mouseY);

    // mouse stuff for potential dragging
    void mouseClicked(int mouseX, int mouseY, int mouseButton);

    void mouseReleased(int mouseX, int mouseY, int mouseButton);

    boolean isMouseWithin(int mouseX, int mouseY);
}
