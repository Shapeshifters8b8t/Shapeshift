package dev.is_a.acaiberii.client.cloosh.ui.rewrite.impl;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import dev.is_a.acaiberii.client.cloosh.ui.rewrite.api.component.AbstractDragComponent;
import net.minecraft.client.gui.Gui;

import java.util.ArrayList;

public class GuiPanel extends AbstractDragComponent {

    public ArrayList<ModuleButton> modButtons;
    public PanelButton button;
    public boolean open;

    public GuiPanel(int x, int y, Category category) {
        super(x, y, 100, 100);
        modButtons = new ArrayList<>();
        int yOffset = 20;
        for (Module m : BeriiOnToppe.modManager.getModsByCategory(category)) {
            modButtons.add(new ModuleButton(x, y + yOffset, width - 1, 15, m));
            yOffset += 16;
        }
        // button height will be 18, and the top of the panel will be 20 tall
        height = (modButtons.size() * 16) + 16;

        button = new PanelButton(x, y, width, 16, category.toString()) {
            @Override
            public void handleClick(int mouseButton) {
                if (mouseButton == 1)
                    open = !open;
            }
        };
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (button.isMouseWithin(mouseX, mouseY)) {
            if (mouseButton == 0) {
                isDragging = true;
                dragX = mouseX - x;
                dragY = mouseY - y;
            }
        }
        if (isMouseWithin(mouseX, mouseY)) {
            handleClick(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    public void renderComponent(int mouseX, int mouseY) {
        if (open) {
            Gui.drawRect(x, y + button.height, x + width, y + height, 0xCF000000);
            int yOffset = 16;
            for (ModuleButton mb : modButtons) {
                mb.setPos(x, y + yOffset);
                mb.draw(mouseX, mouseY);
                yOffset += mb.getSettingsHeight() + mb.height;
            }

            //
            height = yOffset + 1;
        }
        button.setPos(x, y);
        button.draw(mouseX, mouseY);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        if (mouseButton == 0)
            isDragging = false;

        for (ModuleButton mb : modButtons) {
            if (open && mb.open) {
                mb.components.forEach(comp -> comp.mouseReleased(mouseX, mouseY, mouseButton));
            }
        }
    }

    @Override
    public void handleClick(int mouseX, int mouseY, int mouseButton) {
        if (button.isMouseWithin(mouseX, mouseY))
            button.handleClick(mouseButton);

        if (!open)
            return;

        for (ModuleButton mb : modButtons) {
            mb.mouseClicked(mouseX, mouseY, mouseButton);
            if (mb.open) {
                for (BaseComponent c : mb.components)
                    c.mouseClicked(mouseX, mouseY, mouseButton);
            }
        }
    }

    public void keyTyped(char keyChar, int keyCode) {
        for (ModuleButton mb : modButtons) {
            if (mb.open) {
                for (BaseComponent c : mb.components)
                    c.keyTyped(keyChar, keyCode);
            }
        }
    }
}
