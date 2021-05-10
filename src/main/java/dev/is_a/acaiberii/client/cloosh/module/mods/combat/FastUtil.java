package dev.is_a.acaiberii.client.cloosh.module.mods.combat;

import dev.is_a.acaiberii.client.cloosh.events.LocalTickEvent;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import dev.is_a.acaiberii.client.cloosh.setting.impl.BooleanSetting;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FastUtil extends Module {

    public BooleanSetting crystals = new BooleanSetting("Crystals", this,true);
    public BooleanSetting xp = new BooleanSetting("XP", this,true);

    public FastUtil() {
        super("FastUtil", Category.Combat);
        addSettings(xp, crystals);
    }

    @SubscribeEvent
    public void onTick(LocalTickEvent event) {
        if (xp.enabled) {
            if (mc.player.getHeldItemMainhand().getItem() == Items.EXPERIENCE_BOTTLE || mc.player.getHeldItemOffhand().getItem() == Items.EXPERIENCE_BOTTLE) {
                mc.rightClickDelayTimer = 0;
            }
        }

        if (crystals.enabled) {
            if (mc.player.getHeldItemMainhand().getItem() == Items.END_CRYSTAL || mc.player.getHeldItemOffhand().getItem() == Items.END_CRYSTAL) {
                mc.rightClickDelayTimer = 0;
            }
        }
    }
}
