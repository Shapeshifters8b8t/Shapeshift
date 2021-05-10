package me.gavin.gavhack.client.events;

import net.minecraft.util.EnumHandSide;
import net.minecraftforge.fml.common.eventhandler.Event;

public class RenderPlayerHandEvent extends Event {

    private final EnumHandSide hand;

    public RenderPlayerHandEvent(EnumHandSide handIn) {
        this.hand = handIn;
    }

    public EnumHandSide getHand() {
        return hand;
    }
}
