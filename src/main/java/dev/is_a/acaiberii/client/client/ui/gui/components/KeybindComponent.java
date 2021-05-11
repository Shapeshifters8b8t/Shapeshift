package dev.is_a.acaiberii.client.client.ui.gui.components;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.misc.util.FontUtil;
import dev.is_a.acaiberii.client.client.misc.util.Utils;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.ui.gui.Component;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;

public class KeybindComponent extends Component {

    public boolean listeningForKey;

    public KeybindComponent(Module parent, int x, int y, int width, int height, int offset) {
        super(parent, x, y, width, height, offset);
    }

    @Override
    public void draw(int mouseX, int mouseY) {

        if (isMouseWithin(mouseX, mouseY)) {
            Gui.drawRect(x, y, x + width, y + height, 0xcfcccccc);
        } else {
            Gui.drawRect(x, y, x + width, y + height, 0xcf000000);
        }

        if (listeningForKey) {
            FontUtil.drawStringWithShadow("Listening...", x + 3, y + 3, -1);
        } else {
            FontUtil.drawStringWithShadow("Bind: " + Keyboard.getKeyName(parent.keyBind.getKeyCode()), x + 3 , y + 3, -1);
        }

        Gui.drawRect(x, y, x + 1, y + height, BeriiOnToppe.gui.guiColor.getRGB());
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (isMouseWithin(mouseX, mouseY)) {
            Utils.playClick();
            listeningForKey = !listeningForKey;
        }
    }

    @Override
    public void keyTyped(char keyChar, int keyCode) {
        if (listeningForKey) {
            Utils.playClick();
            if (keyCode == Keyboard.KEY_DELETE || keyCode == Keyboard.KEY_BACK) {
                parent.keyBind.setKeyCode(0);
            } else {
                parent.keyBind.setKeyCode(keyCode);
            }
            listeningForKey = false;
        }
    }
}
