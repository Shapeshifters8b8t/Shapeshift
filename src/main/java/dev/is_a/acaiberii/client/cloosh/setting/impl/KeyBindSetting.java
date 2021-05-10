package dev.is_a.acaiberii.client.cloosh.setting.impl;

import dev.is_a.acaiberii.client.cloosh.module.Module;
import dev.is_a.acaiberii.client.cloosh.setting.Setting;

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