package dev.is_a.acaiberii.client.client.module.mods.debug;

import dev.is_a.acaiberii.client.client.events.*;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static dev.is_a.acaiberii.client.client.misc.util.Utils.printMSG;

public class EventDebugger extends Module {
    public EventDebugger() { super("EventDebugger", Category.Debug); }

    @SubscribeEvent
    public void onModeChange(ModeSettingChangedEvent e) {
        printMSG("ModeSettingChangedEvent fired.");
    }

    @SubscribeEvent
    public void onPacketEvent(PacketEvent e) {
        printMSG("PacketEvent fired.");
    }

    @SubscribeEvent
    public void onPlayerMove(PlayerMoveEvent e) {
        printMSG("PlayerMoveEvent fired.");
    }

    @SubscribeEvent
    public void onRender2d(Render2dEvent e) {
        printMSG("Render2dEvent fired.");
    }

    @SubscribeEvent
    public void onRender3d(Render3dEvent e) {
        printMSG("Render3dEvent fired.");
    }

    @SubscribeEvent
    public void onRenderOverlay(RenderOverlayEvent e) {
        printMSG("RenderOverlayEvent e");
    }
}
