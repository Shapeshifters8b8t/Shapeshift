package me.gavin.gavhack.client.module.mods.combat;

import me.gavin.gavhack.client.managers.chat.ChatManager;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.ModeSetting;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoEZ extends Module {
    public ModeSetting ezMode = new ModeSetting("Ez Mode", this, "Regular", "Regular", "Ontoppe");
    private EntityPlayer focus = null;

    public AutoEZ() {
        super("ChatSuffix", Category.Chat);
        addSettings(ezMode);
    }

    @SubscribeEvent
    private void livingDeathEventListenerListener(AttackEntityEvent event) {
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
