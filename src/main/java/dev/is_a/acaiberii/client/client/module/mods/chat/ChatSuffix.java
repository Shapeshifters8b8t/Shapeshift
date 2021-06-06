package dev.is_a.acaiberii.client.client.module.mods.chat;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatSuffix extends Module {
    public ModeSetting suffixMode = new ModeSetting("Suffix", this, "Regular", "Regular", "Ontoppe");
    public ChatSuffix() {
        super("ChatSuffix", Category.Chat);
        addSettings(suffixMode);
    }

    public void onEnable() {
        if (Redtext.INSTANCE.isEnabled()) {
            Redtext.INSTANCE.disable();
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onChat(ClientChatEvent event) {
        if (event.getMessage().startsWith("/") || event.getMessage().startsWith(String.valueOf(BeriiOnToppe.commandManager.prefix)))
            return;

        if (suffixMode.modes.get(suffixMode.index).equals("Regular")) {
            event.setMessage(event.getMessage().concat(" | Shapeshift"));
        }
        else if (suffixMode.modes.get(suffixMode.index).equals("Ontoppe")) {
            event.setMessage(event.getMessage().concat(" | Shapeshift is the on toppest"));
        }

        mc.ingameGUI.getChatGUI().addToSentMessages(event.getOriginalMessage());
    }
}