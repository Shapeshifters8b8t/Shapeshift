package dev.is_a.acaiberii.client.client.module.mods.chat;

import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Shrug extends Module {
    public Shrug() {
        super("Shrug", Category.Chat);
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        String shrugText = "¯\\_(ツ)_/¯";
        event.setMessage(event.getMessage() + " " + shrugText);
    }
}
