package dev.is_a.acaiberii.client.cloosh.module.mods.render;

import dev.is_a.acaiberii.client.cloosh.events.RenderWeatherEvent;
import dev.is_a.acaiberii.client.cloosh.module.Category;
import dev.is_a.acaiberii.client.cloosh.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoWeather extends Module {
    public NoWeather() {
        super("NoWeather", Category.Render);
    }

    @SubscribeEvent
    public void onWeather(RenderWeatherEvent event) {
        event.setCanceled(true);
    }
}
