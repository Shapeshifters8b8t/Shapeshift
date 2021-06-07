package dev.is_a.acaiberii.client.client.module.mods.chat;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.BooleanSetting;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Redtext extends Module {
    private BooleanSetting space = new BooleanSetting("Space", this, true);
    private ModeSetting chatModes = new ModeSetting("Mode", this, "Red", "Red", "Green", "Cyan", "Gold");

    public Redtext() {
        super("Redtext", Category.Chat);
        addSettings(chatModes, space);
    }

    public void onEnable() {

    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        if (event.getMessage().startsWith("/") || event.getMessage().startsWith(String.valueOf(BeriiOnToppe.commandManager.prefix))) return;
        String spacebtw;
        if (space.enabled) spacebtw = " ";
        else spacebtw = "";
        switch (chatModes.modes.get(chatModes.index)) {
            case "Red":
                event.setMessage("@" + spacebtw + event.getMessage());
            case "Green":
                event.setMessage(">" + spacebtw + event.getMessage());
            case "Cyan":
                event.setMessage("^" + spacebtw + event.getMessage());
            case "Gold":
                event.setMessage("$" + spacebtw + event.getMessage());
        }
    }
}
