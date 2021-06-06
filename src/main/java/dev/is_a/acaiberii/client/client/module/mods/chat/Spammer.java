package dev.is_a.acaiberii.client.client.module.mods.chat;

import dev.is_a.acaiberii.client.client.events.LocalTickEvent;
import dev.is_a.acaiberii.client.client.managers.chat.ChatManager;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.BooleanSetting;
import dev.is_a.acaiberii.client.client.setting.impl.NumberSetting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Spammer extends Module {
    public final NumberSetting delay = new NumberSetting("Delay", this, 1, 1, 100, 1);
    public final BooleanSetting bypass = new BooleanSetting("Bypass", this, true);

    private final List<String> messages = new ArrayList<>();
    private int timer;
    private int messageI;

    public Spammer() {
        super("Spammer", Category.Misc);
        this.settings.add(delay);
    }

    public void onEnable() {
        timer = (int) (delay.getValue() * 20);
        messageI = 0;
    }

    @SubscribeEvent
    private void onTick(LocalTickEvent event) {
        if (messages.isEmpty()) return;
        if (timer <= 0) {
            if (bypass.enabled)
                ChatManager.sendChatMessage("Shapeshift ontoppe! " + String.valueOf(new Random().nextInt(99999)));
            else
                ChatManager.sendChatMessage("Shapeshift ontoppe!");
            timer = (int) (delay.getValue() * 20);
        } else {
            timer--;
        }
    }
}
