package me.gavin.gavhack.client.module.mods.misc;

import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.*;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketHeldItemChange;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.network.play.client.CPacketPlayerTryUseItem;
import net.minecraft.util.EnumHand;

import java.util.List;

/**
 * @author Hoosiers
 * @author 0b00101010
 * @since 12/14/2020
 * @since 24/01/2021
 * @author Madmegsox1
 * @since 17/03/2021
 * @implementer AcaiBerii
 * @since 5/10/2021
 */

public class PacketEXP extends Module {
    BooleanSetting sneakOnly = new BooleanSetting("Sneak Only", this, true);
    BooleanSetting noEntityCollision = new BooleanSetting("Prevent Collision", this, true);
    BooleanSetting silentSwitch = new BooleanSetting("Switch", this, true);
    NumberSetting minDamage = new NumberSetting("Minimum Damage", this, 50, 1, 100, 1);
    NumberSetting maxHeal = new NumberSetting("Repair", this, 90, 1, 100, 1);
    BooleanSetting predict = new BooleanSetting("Predict", this, false);

    public PacketEXP() {
        super("PacketEXP", Category.Misc);
        addSettings(sneakOnly, noEntityCollision, silentSwitch, minDamage, maxHeal, predict);
    }

    char toMend = 0;
    public void onUpdate() {
        if (mc.player == null || mc.world == null || mc.player.ticksExisted < 10) {
            return;
        }
        int sumOfDamage = 0;
        List<ItemStack> armour = mc.player.inventory.armorInventory;
        for (int i = 0; i < armour.size(); i++) {
            ItemStack itemStack = armour.get(i);
            if (itemStack.isEmpty) {
                continue;
            }

            //this works better than my calculation for some reason, thank you ArmorHUD.java
            float damageOnArmor = (float) (itemStack.getMaxDamage() - itemStack.getItemDamage());
            float damagePercent = 100 - (100 * (1 - damageOnArmor / itemStack.getMaxDamage()));

            if (damagePercent <= maxHeal.getValue()) {
                if (damagePercent <= minDamage.getValue()) {
                    toMend |= 1 << i;
                }
                if (predict.isEnabled()) {
                    sumOfDamage += (itemStack.getMaxDamage() * maxHeal.getValue() / 100f) - (itemStack.getMaxDamage() - itemStack.getItemDamage());
                }
            } else {
                toMend &= ~(1 << i);
            }
        }
        if (toMend > 0) {
            if (predict.isEnabled()) {
                // get all the xp orbs on top of us
                int totalXp = mc.world.loadedEntityList.stream()
                        .filter(entity -> entity instanceof EntityXPOrb)
                        .filter(entity -> entity.getDistanceSq(mc.player) <= 1)
                        .mapToInt(entity -> ((EntityXPOrb) entity).xpValue).sum();

                // see EntityXpOrbxpToDurability(int xp)
                if ((totalXp * 2) < sumOfDamage) {
                    mendArmor(mc.player.inventory.currentItem);
                }
            } else {
                mendArmor(mc.player.inventory.currentItem);
            }
        }
    }
    private void mendArmor(int oldSlot) {
        if (noEntityCollision.isEnabled()) {
            for (EntityPlayer entityPlayer : mc.world.playerEntities) {
                if (entityPlayer.getDistance(mc.player) < 1 && entityPlayer != mc.player) {
                    return;
                }
            }
        }
        if (sneakOnly.isEnabled() && !mc.player.isSneaking()) {
            return;
        }
        int newSlot = findXPSlot();

        if (newSlot == -1) {
            return;
        }
        if (oldSlot != newSlot) {
            if(silentSwitch.isEnabled()){
                mc.player.connection.sendPacket(new CPacketHeldItemChange(newSlot));
            }
            else {
                mc.player.inventory.currentItem = newSlot;
            }
            mc.playerController.syncCurrentPlayItem();
        }
        mc.player.connection.sendPacket(new CPacketPlayer.Rotation(0, 90, true));
        mc.player.connection.sendPacket(new CPacketPlayerTryUseItem(EnumHand.MAIN_HAND));
        if(silentSwitch.isEnabled()){
            mc.player.connection.sendPacket(new CPacketHeldItemChange(oldSlot));
        }
        else {
            mc.player.inventory.currentItem = oldSlot;
        }
        mc.playerController.syncCurrentPlayItem();
    }
    private int findXPSlot() {
        int slot = -1;
        for (int i = 0; i < 9; i++) {
            if (mc.player.inventory.getStackInSlot(i).getItem() == Items.EXPERIENCE_BOTTLE) {
                slot = i;
                break;
            }
        }
        return slot;
    }
}
