package dev.is_a.acaiberii.client.cloosh.ui.gui;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import dev.is_a.acaiberii.client.cloosh.misc.util.FontUtil;
import net.minecraft.client.gui.Gui;

import java.util.ArrayList;
import java.util.List;
// buttons will be 10x10
public class Panel {

    public int x, y, dragX, dragY, width, height;
    private Category category;
    public boolean open, dragging, pinned;

    public List<ModuleButton> buttons = new ArrayList<>();

    public Panel(List<Module> modules, Category category, int x, int y, int width, int height) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        int yOffset = 0;
        for (Module m : modules) {
            buttons.add(new ModuleButton(m, this, x, y + height + yOffset, 96, 14, yOffset));
            yOffset += 14;
        }
    }

    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        buttons.forEach(moduleButton -> moduleButton.mouseReleased(mouseX, mouseY, mouseButton));
    }

    public void updatePosition(int mouseX, int mouseY) {
        if (this.dragging) {
            this.x = (mouseX - dragX);
            this.y = (mouseY - dragY);
        }
    }

    //public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
    //    panelButton.mouseClicked(mouseX, mouseY, mouseButton);
    //    toggleButton.mouseClicked(mouseX, mouseY, mouseButton);
    //}

    public void draw(int mouseX, int mouseY) {

        Gui.drawRect(x, y, x + width, y + height, BeriiOnToppe.gui.guiColor.getRGB());
        FontUtil.drawStringWithShadow(ChatFormatting.BOLD + category.toString() + " (" + buttons.size() + ")", x + 3, y + 3, -1);

        if (open) {
            buttons.forEach(moduleButton -> {
                moduleButton.setPos(x, y + height + moduleButton.offset);
                moduleButton.draw(mouseX, mouseY);
            });
        }

        //panelButton.setPos(x + width - 12, y + 2);
        //toggleButton.setPos(x + width - 24, y + 2);

        //panelButton.draw(mouseX, mouseY);
        //toggleButton.draw(mouseX, mouseY);
    }

    public boolean isMouseWithinHeader(int mouseX, int mouseY) {
        return mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height;
    }

    public void keyTyped(char keyChar, int keyCode) {
        buttons.forEach(moduleButton -> moduleButton.keyTyped(keyChar, keyCode));
    }
}