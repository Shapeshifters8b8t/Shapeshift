package dev.is_a.acaiberii.client.cloosh.module.mods.misc;

import dev.is_a.acaiberii.client.cloosh.misc.util.Utils;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.common.util.PacketUtil;

public class AutoDupe extends Module {
    public AutoDupe() {
        super("AutoDupe", Category.Misc);
    }

    @Override
    public void onEnable() {
        ItemStack he = mc.player.itemStackMainHand;
        if (mc.player.inventory.hasItemStack(new ItemStack(Block.getBlockFromItem(Item.getItemById(17))))) {
            mc.player.dropItem(he, false);
            mc.player.rotationPitch = 180F;
            mc.timer.tickLength = 50F;
            Utils.printMSG("Craft logs into planks before you pick up the item.");
        }
        else {
            Utils.printMSG("Found no logs in inventory.");
        }
        this.disable();
    }
}
