package dev.is_a.acaiberii.client.client.events;

import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class ModeSettingChangedEvent extends Event {
    private final ModeSetting modeSetting;
    private final String mode;

    public ModeSettingChangedEvent(ModeSetting settingIn, String modeIn) {
        this.modeSetting = settingIn;
        this.mode = modeIn;
    }

    public ModeSetting getSetting() {
        return this.modeSetting;
    }

    public String getMode() {
        return this.mode;
    }
}
