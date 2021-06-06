package dev.is_a.acaiberii.client.client.module.mods.chat;

import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.BooleanSetting;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Redtext extends Module {
    private BooleanSetting space = new BooleanSetting("Space", this, true);
    private ModeSetting chatModes = new ModeSetting("Mode", this, "Red", "Red", "Green", "Cyan");

    public Redtext() {
        super("Redtext", Category.Chat);
        addSettings(chatModes);
    }

    public void onEnable() {
        if (ChatSuffix.INSTANCE.isEnabled()) {
            ChatSuffix.INSTANCE.disable();
        }
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        String spacebtw;
        if (space.enabled) spacebtw = " ";
        else spacebtw = "";
        if (chatModes.modes.get(chatModes.index).equals("Red")) {
            event.setMessage("@" + spacebtw + event.getMessage());
        }
        else if (chatModes.modes.get(chatModes.index).equals("Green")) {
            event.setMessage(">" + spacebtw + event.getMessage());
        }
        else if (chatModes.modes.get(chatModes.index).equals("Cyan")) {
            event.setMessage("^" + spacebtw + event.getMessage());
        }
    }
}
