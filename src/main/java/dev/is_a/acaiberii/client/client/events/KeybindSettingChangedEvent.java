package dev.is_a.acaiberii.client.client.events;

import dev.is_a.acaiberii.client.client.setting.impl.KeyBindSetting;
import net.minecraftforge.fml.common.eventhandler.Event;

public class KeybindSettingChangedEvent extends Event {
    private final KeyBindSetting keySetting;
    private final int key;

    public KeybindSettingChangedEvent(KeyBindSetting settingIn, int keyIn) {
        this.keySetting = settingIn;
        this.key = keyIn;
    }

    public KeyBindSetting getSetting() {
        return this.keySetting;
    }

    public int getKey() { return this.key; }
}
