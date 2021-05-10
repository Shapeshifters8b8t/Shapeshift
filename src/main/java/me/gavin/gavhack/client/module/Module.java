package me.gavin.gavhack.client.module;

import me.gavin.gavhack.client.setting.Setting;
import me.gavin.gavhack.client.setting.impl.KeyBindSetting;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Module {

    public KeyBindSetting keyBind = new KeyBindSetting(Keyboard.KEY_NONE, this);

    public static Module INSTANCE;

    protected Minecraft mc = Minecraft.getMinecraft();

    boolean enabled;
    String name;
    Category category;

    public ArrayList<Setting> settings = new ArrayList<>();

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
        INSTANCE = this;
        addSettings(keyBind);
    }

    public void addSettings(Setting... newSettings) {
        settings.addAll(Arrays.asList(newSettings));
    }

    public String getName() {
        return this.name;
    }

    public Category getCategory() {
        return this.category;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void toggle() {
        if (enabled) {
            disable();
        } else {
            enable();
        }
    }

    public void enable() {
        enabled = true;
        onEnable();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void disable() {
        enabled = false;
        onDisable();
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    public void onEnable() {}

    public void onDisable() {}

    public Setting getSetting(String setting) {
        return settings.stream().filter(setting1 -> setting1.name.equalsIgnoreCase(setting)).findFirst().orElse(null);
    }
}