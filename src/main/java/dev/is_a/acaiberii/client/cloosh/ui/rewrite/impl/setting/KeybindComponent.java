package dev.is_a.acaiberii.client.cloosh.ui.rewrite.impl.setting;

import dev.is_a.acaiberii.client.cloosh.misc.util.FontUtil;
import dev.is_a.acaiberii.client.cloosh.setting.impl.KeyBindSetting;
import dev.is_a.acaiberii.client.cloosh.ui.rewrite.impl.BaseComponent;
import org.lwjgl.input.Keyboard;

public class KeybindComponent extends BaseComponent {

    boolean listening = false;

    public KeyBindSetting parent;

    public KeybindComponent(KeyBindSetting parent, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.parent = parent;
    }

    @Override
    public void draw(int mouseX, int mouseY) {
        if (!listening) {
            FontUtil.drawStringWithShadow("Bind: " + Keyboard.getKeyName(parent.getKeyCode()), x + 3, y + 2, -1);
        } else {
            FontUtil.drawStringWithShadow("Listening...", x + 3, y + 2, -1);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isMouseWithin(mouseX, mouseY) && mouseButton == 0)
            listening = !listening;
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) { }

    @Override
    public void keyTyped(char keyChar, int keyCode) {
        if (listening) {
            listening = false;
            if (keyCode == Keyboard.KEY_DELETE) {
                parent.setKeyCode(Keyboard.KEY_NONE);
                return;
            }

            parent.setKeyCode(keyCode);
        }
    }
}
