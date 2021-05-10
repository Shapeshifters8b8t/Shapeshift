package me.gavin.gavhack.client.module.mods.world;

import me.gavin.gavhack.client.events.LocalTickEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.NumberSetting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Timer extends Module {

    public NumberSetting timer = new NumberSetting("TickLength", this, 60, 5, 200, 5);

    public Timer() {
        super("Timer", Category.World);

        addSettings(timer);
    }

    @SubscribeEvent
    public void onTick(LocalTickEvent event) {
        mc.timer.tickLength = (float) timer.getValue();
    }

    public void onDisable() {
        mc.timer.tickLength = 50f;
    }
}
