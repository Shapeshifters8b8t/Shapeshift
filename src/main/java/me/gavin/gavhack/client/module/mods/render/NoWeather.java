package me.gavin.gavhack.client.module.mods.render;

import me.gavin.gavhack.client.events.RenderWeatherEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
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
