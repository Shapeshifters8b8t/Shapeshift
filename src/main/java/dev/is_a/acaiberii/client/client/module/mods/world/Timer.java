package dev.is_a.acaiberii.client.client.module.mods.world;

import dev.is_a.acaiberii.client.client.events.LocalTickEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.NumberSetting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Timer extends Module {

    public NumberSetting timer = new NumberSetting("Length", this, 60, 5, 400, 5);

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
