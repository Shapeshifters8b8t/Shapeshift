package me.gavin.gavhack.client.module.mods.chat;

import me.gavin.gavhack.BeriiOnToppe;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatSuffix extends Module {
    public ChatSuffix() {
        super("ChatSuffix", Category.Chat);
    }

    String suffix = " | BeriiClient";

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onChat(ClientChatEvent event) {
        if (event.getMessage().startsWith("/") || event.getMessage().startsWith(String.valueOf(BeriiOnToppe.commandManager.prefix)))
            return;

        event.setCanceled(true);

        // done to make sure the suffix is not added onto your message
        // history when you press the up arrow in the chat gui
        mc.getConnection().sendPacket(new CPacketChatMessage(event.getOriginalMessage().concat(suffix)));
        mc.ingameGUI.getChatGUI().addToSentMessages(event.getOriginalMessage());
    }
}