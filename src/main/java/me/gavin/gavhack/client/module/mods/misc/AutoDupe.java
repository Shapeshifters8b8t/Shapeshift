package me.gavin.gavhack.client.module.mods.misc;

import me.gavin.gavhack.client.misc.util.Utils;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AutoDupe extends Module {
    public AutoDupe() {
        super("AutoDupe", Category.Misc);
    }

    @Override
    public void onEnable() {
        if (mc.player.inventory.hasItemStack(new ItemStack(Block.getBlockFromItem(Item.getItemById(17))))) {
            int slot = mc.player.inventory.getSlotFor(new ItemStack(Block.getBlockFromItem(Item.getItemById(17))));
            Minecraft.getMinecraft().playerController.windowClick(Minecraft.getMinecraft().player.inventoryContainer.windowId, slot, 0, ClickType.QUICK_CRAFT, Minecraft.getMinecraft().player);
            Utils.printMSG("Found logs in slot " + slot + ".");
        }
        else {
            Utils.printMSG("Found no logs in inventory.");
        }
        this.disable();
    }
}
