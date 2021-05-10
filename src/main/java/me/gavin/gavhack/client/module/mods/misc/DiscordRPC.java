package me.gavin.gavhack.client.module.mods.misc;

import me.gavin.gavhack.client.misc.DiscordService;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;

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
