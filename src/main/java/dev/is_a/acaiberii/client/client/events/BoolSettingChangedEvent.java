package dev.is_a.acaiberii.client.client.events;

import dev.is_a.acaiberii.client.client.setting.impl.BooleanSetting;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import net.minecraftforge.fml.common.eventhandler.Event;

public class BoolSettingChangedEvent extends Event {
    private final BooleanSetting boolSetting;
    private final boolean bool;

    public BoolSettingChangedEvent(BooleanSetting settingIn, boolean boolIn) {
        this.boolSetting = settingIn;
        this.bool = boolIn;
    }

    public BooleanSetting getSetting() {
        return this.boolSetting;
    }

    public boolean getBool() {
        return this.bool;
    }
}
