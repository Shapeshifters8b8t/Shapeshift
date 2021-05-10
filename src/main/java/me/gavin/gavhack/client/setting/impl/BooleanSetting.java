package me.gavin.gavhack.client.setting.impl;

import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.Setting;

public class BooleanSetting extends Setting {
    public boolean enabled;

    public BooleanSetting(String name, Module parent, boolean enabled) {
        this.name = name;
        this.parent = parent;
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void toggle() {
        this.enabled = !this.enabled;
    }

}