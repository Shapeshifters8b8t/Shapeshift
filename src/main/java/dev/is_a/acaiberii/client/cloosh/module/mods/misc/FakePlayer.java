package dev.is_a.acaiberii.client.cloosh.module.mods.misc;

import com.mojang.authlib.GameProfile;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import net.minecraft.client.entity.EntityOtherPlayerMP;

import java.util.UUID;

public class FakePlayer extends Module {
    public FakePlayer() {
        super("FakePlayer", Category.Misc);
    }

    private EntityOtherPlayerMP fakePlayer;

    public void onEnable() {
        if (mc.world == null)
            return;

        fakePlayer = new EntityOtherPlayerMP(mc.world, new GameProfile(UUID.fromString("fbb6b06a-3ad9-4e07-85b5-9089b3a049cc"), "fake player"));
        fakePlayer.copyLocationAndAnglesFrom(mc.player);
        fakePlayer.rotationYawHead = mc.player.rotationYaw;
        mc.world.addEntityToWorld(-500, fakePlayer);
    }

    public void onDisable() {
        if (fakePlayer == null)
            return;

        mc.world.removeEntity(fakePlayer);
    }
}
