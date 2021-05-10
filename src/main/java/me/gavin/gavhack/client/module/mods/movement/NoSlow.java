package me.gavin.gavhack.client.module.mods.movement;

import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoSlow extends Module {

    public BooleanSetting soulSand = new BooleanSetting("SoulSand", this, true);
    public BooleanSetting cobwebs = new BooleanSetting("Cobwebs", this, false);

    public NoSlow() {
        super("NoSlow", Category.Movement);
        addSettings(soulSand, cobwebs);
    }

    @SubscribeEvent
    public void onInputUpdate(InputUpdateEvent event) {
        if (mc.player.isHandActive() && !mc.player.isRiding()) {
            event.getMovementInput().moveStrafe *= 5;
            event.getMovementInput().moveForward *= 5;
        }
    }
}