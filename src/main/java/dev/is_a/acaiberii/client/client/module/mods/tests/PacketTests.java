package dev.is_a.acaiberii.client.client.module.mods.tests;

import dev.is_a.acaiberii.client.client.managers.packet.PacketManager;
import dev.is_a.acaiberii.client.client.misc.util.Utils;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import net.minecraft.network.play.client.CPacketPlayerAbilities;

public class PacketTests extends Module {

    public PacketTests() {
        super("PacketTests", Category.Tests);
    }

    public void onEnable() {
        PacketManager.sendPacket(new CPacketPlayerAbilities());
        Utils.printMSG("Sent the funny packet.");
    }
}
