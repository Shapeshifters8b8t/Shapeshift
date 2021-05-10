package dev.is_a.acaiberii.client.cloosh.module.mods.render;

import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

import java.util.HashSet;

public class XRay extends Module {
    public XRay() {
        super("XRay", Category.Render);

        xrayBlocks = new HashSet<>();

        xrayBlocks.add(Blocks.DIAMOND_ORE);
        xrayBlocks.add(Blocks.COAL_ORE);
        xrayBlocks.add(Blocks.GOLD_ORE);
        xrayBlocks.add(Blocks.IRON_ORE);
        xrayBlocks.add(Blocks.LAPIS_ORE);
        xrayBlocks.add(Blocks.REDSTONE_ORE);
        xrayBlocks.add(Blocks.LIT_REDSTONE_ORE);
        xrayBlocks.add(Blocks.QUARTZ_ORE);
        xrayBlocks.add(Blocks.WATER);
        xrayBlocks.add(Blocks.FLOWING_WATER);
        xrayBlocks.add(Blocks.LAVA);
        xrayBlocks.add(Blocks.FLOWING_LAVA);

    }

    public static boolean doXray;

    public static HashSet<Block> xrayBlocks;

    public void onEnable() {
        doXray = true;

        if (mc.world == null)
            return;

        mc.renderGlobal.loadRenderers();
    }

    public void onDisable() {
        doXray = false;

        if (mc.world == null)
            return;

        mc.renderGlobal.loadRenderers();
    }
}
