package dev.is_a.acaiberii.client.client.events;

import dev.is_a.acaiberii.client.client.setting.impl.NumberSetting;
import net.minecraftforge.fml.common.eventhandler.Event;

public class NumberSettingChangedEvent extends Event {
    private final NumberSetting numSetting;
    private final double num;

    public NumberSettingChangedEvent(NumberSetting settingIn, double numberIn) {
        this.numSetting = settingIn;
        this.num = numberIn;
    }

    public NumberSetting getSetting() { return this.numSetting; }

    public double getNum() { return this.num; }
}
