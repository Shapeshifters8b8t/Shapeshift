package me.gavin.gavhack.client.module.mods.world;

import me.gavin.gavhack.client.events.LocalTickEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FastPlace extends Module {

    public BooleanSetting noBreakDelay = new BooleanSetting("NoBreakDelay", this, false);

    public FastPlace() {
        super("FastPlace", Category.World);
        addSettings(noBreakDelay);
    }

    @SubscribeEvent
    public void onTick(LocalTickEvent event) {
        mc.rightClickDelayTimer = 0;

        if (noBreakDelay.enabled) {
            mc.playerController.blockHitDelay = 0;
        }
    }
}
