package me.gavin.gavhack.client.module.mods.render;

import me.gavin.gavhack.client.events.LocalTickEvent;
import me.gavin.gavhack.client.events.PacketEvent;
import me.gavin.gavhack.client.events.PlayerMoveEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import me.gavin.gavhack.client.setting.impl.NumberSetting;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketInput;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.client.event.PlayerSPPushOutOfBlocksEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

// ghetto freecam implemented from an older client of mine
public class Freecam extends Module {

    public BooleanSetting cancelPackets = new BooleanSetting("CancelPackets", this, true);
    public NumberSetting flySpeed = new NumberSetting("FlySpeed", this, 10, 1, 30, 1);

    public Freecam() {
        super("Freecam", Category.Render);
        addSettings(cancelPackets, flySpeed);
    }

    private double posX, posY, posZ;
    private float pitch, yaw;

    private EntityOtherPlayerMP clonedPlayer;

    private boolean isRidingEntity;
    private Entity ridingEntity;

    public void onEnable() {
        if (mc.player == null)
            return;

        mc.renderGlobal.loadRenderers();

        isRidingEntity = mc.player.getRidingEntity() != null;

        if (mc.player.getRidingEntity() == null) {
            posX = mc.player.posX;
            posY = mc.player.posY;
            posZ = mc.player.posZ;
        } else {
            ridingEntity = mc.player.getRidingEntity();
            mc.player.dismountRidingEntity();
        }

        pitch = mc.player.rotationPitch;
        yaw = mc.player.rotationYaw;

        clonedPlayer = new EntityOtherPlayerMP(mc.world, mc.getSession().getProfile());
        clonedPlayer.copyLocationAndAnglesFrom(mc.player);
        clonedPlayer.rotationYawHead = mc.player.rotationYawHead;
        mc.world.addEntityToWorld(-100, clonedPlayer);
        mc.player.capabilities.isFlying = true;
        mc.player.capabilities.setFlySpeed((float) (flySpeed.getValue() / 100f));
        mc.player.noClip = true;
    }

    public void onDisable() {
        EntityPlayer localPlayer = mc.player;
        if (localPlayer != null) {
            mc.player.setPositionAndRotation(posX, posY, posZ, yaw, pitch);
            mc.world.removeEntityFromWorld(-100);
            clonedPlayer = null;
            posX = posY = posZ = 0.D;
            pitch = yaw = 0.f;
            mc.player.capabilities.isFlying = false;
            mc.player.capabilities.setFlySpeed(0.05f);
            mc.player.noClip = false;
            mc.player.motionX = mc.player.motionY = mc.player.motionZ = 0.f;

            if (isRidingEntity) {
                mc.player.startRiding(ridingEntity, true);
            }
        }

        mc.renderGlobal.loadRenderers();
    }

    @SubscribeEvent
    public void onTick(LocalTickEvent event) {
        mc.player.capabilities.isFlying = true;
        mc.player.capabilities.setFlySpeed((float) (flySpeed.getValue() / 100f));
        mc.player.noClip = true;
        mc.player.onGround = false;
        mc.player.fallDistance = 0;
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Send event) {
        if (!cancelPackets.enabled)
            return;

        if (event.getPacket() instanceof CPacketPlayer || event.getPacket() instanceof CPacketInput)
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void onMove(PlayerMoveEvent event) {
        mc.player.noClip = true;
    }

    @SubscribeEvent
    public void onPush(PlayerSPPushOutOfBlocksEvent event) {
        event.setCanceled(true);
    }
}
