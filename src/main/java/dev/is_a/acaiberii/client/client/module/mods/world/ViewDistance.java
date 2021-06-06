package dev.is_a.acaiberii.client.client.module.mods.world;

import dev.is_a.acaiberii.client.client.module.Category;
import dev.is_a.acaiberii.client.client.module.Module;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static dev.is_a.acaiberii.client.client.misc.util.Utils.printMSG;

public class ViewDistance extends Module {
    public ViewDistance() { super("ViewDistance", Category.World); }

    @SubscribeEvent
    public void onPlayerRender(RenderPlayerEvent e) {
        if (!e.getEntityPlayer().getName().equals(mc.player.getName())) {
            printMSG(e.getEntityPlayer().getName() + " has entered your view distance!");
        }
    }
}
