package dev.is_a.acaiberii.client.client.module.mods.misc;

import dev.is_a.acaiberii.client.client.misc.DiscordService;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;

public class DiscordRPC extends Module {
    public DiscordRPC() {
        super("DiscordRPC", Category.Misc);
    }

    public void onEnable() {
        DiscordService.startRPC();
    }

    public void onDisable() {
        DiscordService.stopRPC();
    }
}
