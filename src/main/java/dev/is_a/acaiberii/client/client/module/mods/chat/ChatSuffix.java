package dev.is_a.acaiberii.client.client.module.mods.chat;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.lang3.StringEscapeUtils;

public class ChatSuffix extends Module {

    public ChatSuffix() {
        super("ChatSuffix", Category.Chat);
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        if (event.getMessage().startsWith("/") || event.getMessage().startsWith(String.valueOf(BeriiOnToppe.commandManager.prefix)))
            return;
        event.setMessage(event.getMessage().concat(StringEscapeUtils.unescapeCsv(" | shapeshift")));
        mc.ingameGUI.getChatGUI().addToSentMessages(event.getOriginalMessage());
    }
}