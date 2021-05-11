package dev.is_a.acaiberii.client.client.managers.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;

import java.util.Objects;

public class PacketManager {
    public static void SendPacket(Packet pack) {
        Objects.requireNonNull(Minecraft.getMinecraft().getConnection()).sendPacket(pack);
    }
}
