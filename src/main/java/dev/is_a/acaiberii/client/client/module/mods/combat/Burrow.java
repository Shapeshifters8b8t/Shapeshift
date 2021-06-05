package dev.is_a.acaiberii.client.client.module.mods.combat;

import dev.is_a.acaiberii.client.client.misc.util.Utils;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.BooleanSetting;
import dev.is_a.acaiberii.client.client.setting.impl.NumberSetting;
import me.zero.alpine.listener.Listener;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static net.minecraft.network.play.client.CPacketEntityAction.Action.START_SNEAKING;

/// skidded idc :D

public class Burrow extends Module {
    private final BooleanSetting rotate = new BooleanSetting("Rotate", this, false);
    private final NumberSetting offset = new NumberSetting("Offset", this, 7, 0, 20, 1);
    private final BooleanSetting sneak = new BooleanSetting("Sneak", this, false);

    private BlockPos originalPos;
    private int oldSlot = -1;

    public Burrow() {
        super("InstantBurrow", Category.Combat);
        addSettings(rotate, offset);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        originalPos = new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ);
        if (mc.world.getBlockState(new BlockPos(mc.player.posX, mc.player.posY, mc.player.posZ)).getBlock().equals(Blocks.OBSIDIAN) ||
                intersectsWithEntity(this.originalPos)) {
            toggle();
            return;
        }
        oldSlot = mc.player.inventory.currentItem;
    }

    private final Listener<TickEvent.ClientTickEvent> onTick = new Listener<>(event -> {
        if (BurrowUtil.findHotbarBlock(BlockObsidian.class) == -1) {
            Utils.printMSG("Can't find obsidian in hotbar.");
            toggle();
            return;
        }
        BurrowUtil.switchToSlot(BurrowUtil.findHotbarBlock(BlockObsidian.class));
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.41999998688698D, mc.player.posZ, true));
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 0.7531999805211997D, mc.player.posZ, true));
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.00133597911214D, mc.player.posZ, true));
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + 1.16610926093821D, mc.player.posZ, true));
        boolean sneaking = mc.player.isSneaking();
        if (sneak.enabled) {
            if (sneaking) {
                mc.player.connection.sendPacket(new CPacketEntityAction(mc.player, START_SNEAKING));
            }
        }
        BurrowUtil.placeBlock(originalPos, EnumHand.MAIN_HAND, rotate.isEnabled(), true, false);
        mc.player.connection.sendPacket(new CPacketPlayer.Position(mc.player.posX, mc.player.posY + offset.getValue(), mc.player.posZ, false));
        BurrowUtil.switchToSlot(oldSlot);
        toggle();
    });

    private boolean intersectsWithEntity(final BlockPos pos) {
        for (final Entity entity : mc.world.loadedEntityList) {
            if (entity.equals(mc.player)) continue;
            if (entity instanceof EntityItem) continue;
            if (new AxisAlignedBB(pos).intersects(entity.getEntityBoundingBox())) return true;
        }
        return false;
    }
}
