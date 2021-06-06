package dev.is_a.acaiberii.client.client.module.mods.misc;

import dev.is_a.acaiberii.client.client.misc.DiscordService;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.BooleanSetting;

public class DiscordRPC extends Module {
    public BooleanSetting displayServer = new BooleanSetting("Display server", this, false);
    public DiscordRPC() {
        super("DiscordRPC", Category.Misc);
        this.settings.add(displayServer);
    }

    public void onEnable() { DiscordService.startRPC(); }

    public void onDisable() {
        DiscordService.stopRPC();
    }
}
