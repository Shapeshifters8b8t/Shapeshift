package dev.is_a.acaiberii.client;

import dev.is_a.acaiberii.client.client.command.CommandManager;
import dev.is_a.acaiberii.client.client.misc.ConfigSystem;
import dev.is_a.acaiberii.client.client.misc.EventProcessor;
import dev.is_a.acaiberii.client.client.misc.font.CFontRenderer;
import dev.is_a.acaiberii.client.client.misc.util.CapeUtil;
import dev.is_a.acaiberii.client.client.module.ModuleManager;
import dev.is_a.acaiberii.client.client.ui.gui.GuiHackManager;
import dev.is_a.acaiberii.client.client.ui.hud.HUD;
import dev.is_a.acaiberii.client.client.ui.hud.HudEditorScreen;
import dev.is_a.acaiberii.client.client.ui.rewrite.impl.ClickGuiScreen;

import java.awt.*;

public class ClientBootstrapper {

    public ClientBootstrapper() {
        initializeClient();
    }

    void initializeClient() {
        BeriiOnToppe.eventProcessor = new EventProcessor();
        BeriiOnToppe.log("Event Processor initialized");

        BeriiOnToppe.cfont = new CFontRenderer(new Font("Veranda", Font.PLAIN, 18), true,  true);
        BeriiOnToppe.log("Hal Font Renderer initialized");

        BeriiOnToppe.modManager = new ModuleManager();
        BeriiOnToppe.log("Module Manager initialized");

        BeriiOnToppe.commandManager = new CommandManager();
        BeriiOnToppe.log("Command Manager initialized");

        BeriiOnToppe.capeUtil = new CapeUtil();
        BeriiOnToppe.log("Cape Util initialized");

        BeriiOnToppe.clickGui = new ClickGuiScreen();
        BeriiOnToppe.log("ClickGUI initialized");

        BeriiOnToppe.gui = new GuiHackManager();
        BeriiOnToppe.log("Old ClickGUI initialized");

        BeriiOnToppe.hudEditor = new HudEditorScreen();
        BeriiOnToppe.log("HudEditor initialized");

        BeriiOnToppe.hud = new HUD();
        BeriiOnToppe.log("HUD initialized");

        BeriiOnToppe.configSystem = new ConfigSystem();
        BeriiOnToppe.configSystem.loadModulesAndSettings();
        BeriiOnToppe.configSystem.loadOtherValues();
        Runtime.getRuntime().addShutdownHook(BeriiOnToppe.configSystem);
        BeriiOnToppe.log("Config System initialized");

        BeriiOnToppe.log("Completed BeriiClient initialization");
    }
}
