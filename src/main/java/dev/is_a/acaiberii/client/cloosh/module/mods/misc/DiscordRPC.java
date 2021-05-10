package dev.is_a.acaiberii.client.cloosh.module.mods.misc;

import dev.is_a.acaiberii.client.cloosh.misc.DiscordService;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;

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
