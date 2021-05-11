package dev.is_a.acaiberii.client.client.module.mods.tests;

import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.managers.chat.ChatManager;

public class ChatTests extends Module {
    public ChatTests() {
        super("ChatTests", Category.Tests);
    }

    public void onEnable() {
        ChatManager.sendChatMessage("This is a test!1!");
    }
}
