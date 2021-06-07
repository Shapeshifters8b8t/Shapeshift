package dev.is_a.acaiberii.client.client.ui.hud;

import dev.is_a.acaiberii.client.client.events.Render2dEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HUD {

    public HUD() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    // will be used for hud editor later
    @SubscribeEvent
    public void onRender(Render2dEvent event) {

        if (Minecraft.getMinecraft().currentScreen != null)
            return;
    }
}
