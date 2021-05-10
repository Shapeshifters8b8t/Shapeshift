package dev.is_a.acaiberii.client;

import dev.is_a.acaiberii.client.cloosh.command.CommandManager;
import dev.is_a.acaiberii.client.cloosh.misc.ConfigSystem;
import dev.is_a.acaiberii.client.cloosh.misc.EventProcessor;
import dev.is_a.acaiberii.client.cloosh.misc.font.CFontRenderer;
import dev.is_a.acaiberii.client.cloosh.misc.util.CapeUtil;
import dev.is_a.acaiberii.client.cloosh.module.ModuleManager;
import dev.is_a.acaiberii.client.cloosh.ui.gui.GuiHackManager;
import dev.is_a.acaiberii.client.cloosh.ui.hud.HUD;
import dev.is_a.acaiberii.client.cloosh.ui.hud.HudEditorScreen;
import dev.is_a.acaiberii.client.cloosh.ui.rewrite.impl.ClickGuiScreen;
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
    public static final String MODID = "gavhack";
    public static final String NAME = "Gavhack";
    public static final String VERSION = "b3";

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