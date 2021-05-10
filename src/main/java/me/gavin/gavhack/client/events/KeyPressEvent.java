package me.gavin.gavhack.client.events;

import net.minecraftforge.fml.common.eventhandler.Event;

public class KeyPressEvent extends Event {

    private final int key;

    public KeyPressEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }
}