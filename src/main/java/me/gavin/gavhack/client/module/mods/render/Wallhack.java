package me.gavin.gavhack.client.module.mods.render;

import me.gavin.gavhack.client.events.RenderEntityEvent;
import me.gavin.gavhack.client.module.Category;
import me.gavin.gavhack.client.module.Module;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class Wallhack extends Module {

    public BooleanSetting players = new BooleanSetting("Players", this, true);
    public BooleanSetting mobs = new BooleanSetting("Mobs", this, false);
    public BooleanSetting animals = new BooleanSetting("Animals", this, false);
    public BooleanSetting items = new BooleanSetting("Items", this, false);

    public Wallhack() {
        super("Wallhack", Category.Render);
        addSettings(players, mobs, animals, items);
    }

    // i will come up with a better way to do the modes
    // im super tired rn
    @SubscribeEvent
    public void onRender(RenderEntityEvent event) {
        if (event.getType() == RenderEntityEvent.Type.PRE) {
            if (event.getEntity() instanceof EntityPlayer && players.enabled) {
                preCham();
                return;
            }

            if (event.getEntity() instanceof EntityMob && mobs.enabled) {
                preCham();
                return;
            }

            if (event.getEntity() instanceof EntityAnimal && animals.enabled) {
                preCham();
                return;
            }

            if (event.getEntity() instanceof EntityItem && items.enabled) {
                preCham();
                return;
            }
        }


        if (event.getType() == RenderEntityEvent.Type.POST) {
            if (event.getEntity() instanceof EntityPlayer && players.enabled) {
                postCham();
                return;
            }

            if (event.getEntity() instanceof EntityMob && mobs.enabled) {
                postCham();
                return;
            }

            if (event.getEntity() instanceof EntityAnimal && animals.enabled) {
                postCham();
                return;
            }

            if (event.getEntity() instanceof EntityItem && items.enabled) {
                postCham();
                return;
            }
        }

    }

    void preCham() {
        mc.renderManager.renderShadow = false;
        GL11.glDepthRange(0, 0.01);
    }

    void postCham() {
        GL11.glDepthRange(0, 1);
        mc.renderManager.renderShadow = mc.gameSettings.entityShadows;
    }
}
