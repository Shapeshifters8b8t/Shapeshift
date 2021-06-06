package dev.is_a.acaiberii.client.client.module.mods.movement;

import dev.is_a.acaiberii.client.client.events.KeyPressEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import dev.is_a.acaiberii.client.client.setting.impl.ModeSetting;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

public class Flight extends Module {
    public Flight() {
        super("Flight", Category.Movement);
    }

    public void onEnable() {
        mc.player.capabilities.isFlying = true;
    }

    public void onDisable() {
        mc.player.capabilities.isFlying = false;
    }
}
