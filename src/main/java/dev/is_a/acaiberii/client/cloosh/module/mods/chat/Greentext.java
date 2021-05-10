package dev.is_a.acaiberii.client.cloosh.module.mods.chat;

import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Greentext extends Module {
    public Greentext() {
        super("Greentext", Category.Chat);
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        event.setMessage(">" + event.getMessage());
    }
}
