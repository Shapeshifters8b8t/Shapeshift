package me.gavin.gavhack.client.managers.chat;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.CPacketChatMessage;

public class ChatManager {
    public static void sendChatMessage(String message) {
        Minecraft.getMinecraft().getConnection().sendPacket(new CPacketChatMessage(message));
        Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages(message);
    }
}
