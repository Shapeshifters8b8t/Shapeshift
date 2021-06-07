package dev.is_a.acaiberii.client.client.module.mods.render;

import dev.is_a.acaiberii.client.client.events.RenderWeatherEvent;
import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
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
