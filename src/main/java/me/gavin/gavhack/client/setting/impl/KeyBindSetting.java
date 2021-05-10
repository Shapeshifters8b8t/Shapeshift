package me.gavin.gavhack.client.setting.impl;

import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.Setting;

public class KeyBindSetting extends Setting {
    public int code;

    public KeyBindSetting(int code, Module parent) {
        this.name = "KeyBind";
        this.code = code;
        this.parent = parent;
    }

    public int getKeyCode() {
        return this.code;
    }

    public void setKeyCode(int code) {
        this.code = code;
    }
}