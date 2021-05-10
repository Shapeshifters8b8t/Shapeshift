package me.gavin.gavhack.client.module.mods.combat;

import me.gavin.gavhack.client.events.LocalTickEvent;
import me.gavin.gavhack.client.events.PacketEvent;
import me.gavin.gavhack.client.misc.util.RenderUtil;
import me.gavin.gavhack.client.misc.util.TimerUtil;
import me.gavin.gavhack.client.misc.util.Utils;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import me.gavin.gavhack.client.setting.impl.ModeSetting;
import me.gavin.gavhack.client.setting.impl.NumberSetting;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.play.server.SPacketSoundEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.awt.*;
import java.util.Comparator;

public class AutoCrystal extends Module {

    public BooleanSetting placeSetting = new BooleanSetting("Place", this, true);
    public BooleanSetting breakSetting = new BooleanSetting("Break", this, true);
    public NumberSetting rangeSetting = new NumberSetting("Range", this, 4.0, 1.0, 8.0, 0.5);
    public BooleanSetting placeboMode = new BooleanSetting("SetDead", this, false);
    public BooleanSetting doRender = new BooleanSetting("Render", this, true);
    public NumberSetting breakDelayMS = new NumberSetting("BreakDelay", this, 3, 1, 20, 1);
    public ModeSetting breakMode = new ModeSetting("BreakMode", this, "Self", "Self", "Nearest");

    public AutoCrystal() {
        super("AutoCrystal", Category.Combat);
        addSettings(
                placeSetting,
                breakSetting,
                rangeSetting,
                placeboMode,
                doRender,
                breakDelayMS/*,
                breakMode*/);
    }

    @SubscribeEvent
    public void onTick(LocalTickEvent event) {
        nearestCrystal = mc.world.loadedEntityList.stream()
                .filter(entity -> entity instanceof EntityEnderCrystal)
                .filter(entity -> mc.player.getDistance(entity) <= rangeSetting.getValue())
                .map(entity -> (EntityEnderCrystal) entity)
                .min(Comparator.comparing(crystal -> mc.player.getDistance(crystal)))
                .orElse(null);

        if (placeSetting.enabled)
            doPlaceLogic();

        if (breakSetting.enabled)
            doBreakLogic();
    }

    @SubscribeEvent
    public void onRender(RenderWorldLastEvent event) {
        if (!doRender.enabled)
            return;

        if (nearestCrystal == null)
            return;

        Color r = new Color(Utils.getRGB(6, 1, 0.6f));
        BlockPos pos = nearestCrystal.getPosition().add(0, -1, 0);

        if (!(mc.world.getBlockState(pos).getBlock() == Blocks.OBSIDIAN || mc.world.getBlockState(pos).getBlock() == Blocks.BEDROCK))
            return;

        AxisAlignedBB bb = RenderUtil.generateBB(pos.getX(), pos.getY(), pos.getZ());
        RenderUtil.drawBoxOutline(bb, r.getRed() / 255f, r.getGreen() / 255f, r.getBlue() / 255f, 0.5f);
    }

    private void doPlaceLogic() {

    }

    EntityEnderCrystal nearestCrystal;
    TimerUtil timer = new TimerUtil();

    private void doBreakLogic() {

        if (nearestCrystal != null && timer.hasTimeElapsed((long)breakDelayMS.getValue() * 50, true)) {
            mc.player.swingArm(EnumHand.MAIN_HAND);
            mc.playerController.attackEntity(mc.player, nearestCrystal);
        }
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Receive event) {
        if (!placeboMode.enabled)
            return;
        if (event.getPacket() instanceof SPacketSoundEffect) {
            SPacketSoundEffect soundPacket = (SPacketSoundEffect) event.getPacket();
            if (soundPacket.sound == SoundEvents.ENTITY_GENERIC_EXPLODE) {
                event.setCanceled(true);
                if (nearestCrystal != null)
                    nearestCrystal.setDead();
            }
        }
    }
}