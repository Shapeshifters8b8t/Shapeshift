package dev.is_a.acaiberii.client.client.misc;

import club.minnced.discord.rpc.DiscordEventHandlers;
import club.minnced.discord.rpc.DiscordRPC;
import club.minnced.discord.rpc.DiscordRichPresence;
import net.minecraft.client.Minecraft;

import java.util.Objects;

public class DiscordService {

    private static String discordID = "825553971358990336";
    private static DiscordRichPresence richPresence = new DiscordRichPresence();
    private static DiscordRPC discordRPC = DiscordRPC.INSTANCE;

    public static void startRPC() {
        DiscordEventHandlers handlers = new DiscordEventHandlers();
        discordRPC.Discord_Initialize(discordID, handlers, true, null);
        richPresence.startTimestamp = System.currentTimeMillis() / 1000L;
        richPresence.details = "Playing Shapeshift";
        richPresence.largeImageKey = "moon_1";
        //richPresence.smallImageKey = "moon_1";
        richPresence.state = null;
        discordRPC.Discord_UpdatePresence(richPresence);
    }

    public static void stopRPC() {
        discordRPC.Discord_Shutdown();
        discordRPC.Discord_ClearPresence();
    }
}
