package me.gavin.gavhack.client.module.mods.world;

import me.gavin.gavhack.client.events.PacketEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.mixin.mixins.accessor.AccessorCPacketCloseWindow;
import net.minecraft.network.play.client.CPacketCloseWindow;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class XCarry extends Module {
    public XCarry() {
        super("XCarry", Category.World);
    }

    @SubscribeEvent
    public void onPacket(PacketEvent.Send event) {
        if (event.getPacket() instanceof CPacketCloseWindow) {
            CPacketCloseWindow packet = (CPacketCloseWindow) event.getPacket();
            if (((AccessorCPacketCloseWindow) packet).getWindowId() == mc.player.inventoryContainer.windowId)
                event.setCanceled(true);
        }
    }
}
