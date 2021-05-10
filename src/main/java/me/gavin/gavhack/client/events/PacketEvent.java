package me.gavin.gavhack.client.events;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

@Cancelable
public class PacketEvent extends Event {

    public static class Send extends PacketEvent {
        private Packet packet;

        public Send(Packet packetIn) {
            this.packet = packetIn;
        }

        public Packet getPacket() {
            return this.packet;
        }

        public void setPacket(Packet packetIn) {
            this.packet = packetIn;
        }
    }

    public static class Receive extends PacketEvent {
        private Packet packet;

        public Receive(Packet packetIn) {
            this.packet = packetIn;
        }

        public Packet getPacket() {
            return this.packet;
        }

        public void setPacket(Packet packetIn) {
            this.packet = packetIn;
        }
    }
}