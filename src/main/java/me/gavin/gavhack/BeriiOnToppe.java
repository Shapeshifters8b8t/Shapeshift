package me.gavin.gavhack;

import me.gavin.gavhack.client.command.CommandManager;
import me.gavin.gavhack.client.misc.ConfigSystem;
import me.gavin.gavhack.client.misc.EventProcessor;
import me.gavin.gavhack.client.misc.font.CFontRenderer;
import me.gavin.gavhack.client.misc.util.CapeUtil;
import me.gavin.gavhack.client.module.ModuleManager;
import me.gavin.gavhack.client.ui.gui.GuiHackManager;
import me.gavin.gavhack.client.ui.hud.HUD;
import me.gavin.gavhack.client.ui.hud.HudEditorScreen;
import me.gavin.gavhack.client.ui.rewrite.impl.ClickGuiScreen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

// gui color palette

// primary / enabled : FA0852
// secondary : 7F07DE
// disabled will be gray or something
@Mod(modid = BeriiOnToppe.MODID, name = BeriiOnToppe.NAME, version = BeriiOnToppe.VERSION)
public class BeriiOnToppe {
    public static final String MODID = "beriiclient";
    public static final String NAME = "BeriiClient";
    public static final String VERSION = "b1";

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        new ClientBootstrapper();
    }

    public static CFontRenderer cfont;
    public static ModuleManager modManager;
    public static CommandManager commandManager;
    public static GuiHackManager gui;
    public static HudEditorScreen hudEditor;
    public static CapeUtil capeUtil;
    public static EventProcessor eventProcessor;
    public static ConfigSystem configSystem;
    public static HUD hud;
    public static ClickGuiScreen clickGui;

    public static void log(String info) {
        logger.info(info);
    }
}