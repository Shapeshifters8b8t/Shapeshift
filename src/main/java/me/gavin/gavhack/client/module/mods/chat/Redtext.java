package me.gavin.gavhack.client.module.mods.chat;

import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.ModeSetting;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

public class Redtext extends Module {
    private ModeSetting Mode = new ModeSetting("Mode", this, "Red", "Red", "Green", "Cyan");

    public Redtext() {
        super("Redtext", Category.Chat);
        addSettings(Mode);
    }

    @SubscribeEvent
    public void onChat(ClientChatEvent event) {
        if (Mode.getMode().equals("Red")) {
            event.setMessage("@" + event.getMessage());
        }
        else if (Mode.getMode().equals("Green")) {
            event.setMessage(">" + event.getMessage());
        }
        else if (Mode.getMode().equals("Cyan")) {
            event.setMessage("^" + event.getMessage());
        }
    }
}
