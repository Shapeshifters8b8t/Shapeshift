package dev.is_a.acaiberii.client.cloosh.module.mods.world;

import dev.is_a.acaiberii.client.cloosh.events.LocalTickEvent;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import dev.is_a.acaiberii.client.cloosh.setting.impl.BooleanSetting;
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
