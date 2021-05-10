package dev.is_a.acaiberii.client.mixes.mixins;

import io.netty.channel.ChannelHandlerContext;
import dev.is_a.acaiberii.client.cloosh.events.PacketEvent;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraftforge.common.MinecraftForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetworkManager.class)
public class MixinNetworkManager {

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    public void onPacketSend(Packet<?> packet, CallbackInfo ci) {
        PacketEvent.Send packetEvent = new PacketEvent.Send(packet);
        MinecraftForge.EVENT_BUS.post(packetEvent);
        packet = packetEvent.getPacket();
        if (packetEvent.isCanceled())
            ci.cancel();
    }

    @Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
    public void onPacketRead(ChannelHandlerContext chc, Packet<?> packet, CallbackInfo ci) {
        PacketEvent.Receive packetEvent = new PacketEvent.Receive(packet);
        MinecraftForge.EVENT_BUS.post(packetEvent);
        packet = packetEvent.getPacket();
        if (packetEvent.isCanceled())
            ci.cancel();
    }
}
