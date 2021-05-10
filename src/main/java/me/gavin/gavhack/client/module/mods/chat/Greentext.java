package me.gavin.gavhack.client.module.mods.chat;

import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
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
