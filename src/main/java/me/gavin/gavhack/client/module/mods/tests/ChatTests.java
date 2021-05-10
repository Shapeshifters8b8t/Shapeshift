package me.gavin.gavhack.client.module.mods.tests;

import me.gavin.gavhack.client.managers.chat.ChatManager;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;

public class ChatTests extends Module {
    public ChatTests() {
        super("ChatTests", Category.Tests);
    }

    public void onEnable() {
        ChatManager.sendChatMessage("This is a test!1!");
    }
}
