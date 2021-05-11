package dev.is_a.acaiberii.client.client.module.mods.combat;

import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import dev.is_a.acaiberii.client.client.managers.chat.ChatManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoEZ extends Module {
    public ModeSetting ezMode = new ModeSetting("Ez Mode", this, "Regular", "Regular", "Ontoppe");
    private EntityPlayer focus = null;

    public AutoEZ() {
        super("AutoEZ", Category.Combat);
        addSettings(ezMode);
    }

    @SubscribeEvent
    public void livingDeathEventListenerListener(AttackEntityEvent event) {
        if (Minecraft.getMinecraft().player.isEntityAlive()) {
            if (event.getTarget() instanceof EntityPlayer) {
                focus = (EntityPlayer) event.getTarget();
                if (event.getEntityPlayer().getUniqueID() == Minecraft.getMinecraft().player.getUniqueID()) {
                    if (focus.getHealth() <= 0.0 || focus.isDead || !Minecraft.getMinecraft().world.playerEntities.contains(focus)) {
                        if (ezMode.modes.get(ezMode.index).equals("Regular")) {
                            ChatManager.sendChatMessage("Hey " + focus.getDisplayNameString() + ", you just got EZ'd by BeriiClient!");
                        }
                        else if (ezMode.modes.get(ezMode.index).equals("Ontoppe")) {
                            ChatManager.sendChatMessage("Hey " + focus.getDisplayNameString() + ", did you know that BeriiClient is ontoppe?");
                        }
                        return;
                    }
                }
            }
        }
    }
}
