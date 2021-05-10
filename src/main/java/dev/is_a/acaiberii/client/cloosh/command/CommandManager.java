package dev.is_a.acaiberii.client.cloosh.command;

import dev.is_a.acaiberii.client.cloosh.command.commands.*;
import dev.is_a.acaiberii.client.cloosh.events.KeyPressEvent;
import dev.is_a.acaiberii.client.cloosh.command.commands.*;
import dev.is_a.acaiberii.client.cloosh.misc.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;

// made partly by following the command tutorial from "intent store" on youtube
// because i have never made a command system before :)
public class CommandManager {

    Minecraft mc = Minecraft.getMinecraft();

    public CommandManager() {
        MinecraftForge.EVENT_BUS.register(this);
        init();
    }

    ArrayList<CommandBase> commands = new ArrayList<>();

    private void init() {
        add(new ToggleCMD());
        add(new HelpCMD());
        add(new PrefixCMD());
        add(new ModulesCMD());
        add(new BindCMD());
        add(new SayCMD());
        add(new LegitCMD());

        commands.sort(this::compareTo);
    }

    // sort commands alphabetically
    private int compareTo(CommandBase cmd1, CommandBase cmd2) {
        return Integer.compare(cmd1.getName().compareTo(cmd2.getName()), 0);
    }

    private void add(CommandBase command) {
        commands.add(command);
    }

    public ArrayList<CommandBase> getCommands() {
        return commands;
    }

    public char prefix = '.';

    // listening for chat events
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onChat(ClientChatEvent event) {
        String message = event.getMessage();
        if (message.startsWith(String.valueOf(prefix))) {
            event.setCanceled(true);
            // command logic
            mc.ingameGUI.getChatGUI().addToSentMessages(message);

            if (message.length() == 1) {
                Utils.printMSG("You must specify a command");
                return;
            }

            message = message.substring(1);

            if (message.split(" ").length > 0) {
                String cmdName = message.split(" ")[0];
                for (CommandBase c : commands) {
                    if (c.getAliases().contains(cmdName) ||c.getName().equalsIgnoreCase(cmdName)) {
                        c.onCommand(Arrays.copyOfRange(message.split(" "), 1, message.split(" ").length), message);
                        return;
                    }
                }
                Utils.printMSG("Command not found, type " + prefix + "help for a list of commands");
            } else {
                Utils.printMSG("Invalid command syntax");
            }
        }
    }

    @SubscribeEvent
    public void onKey(KeyPressEvent event) {
        if (prefix == Keyboard.getEventCharacter()) {
            mc.displayGuiScreen(new GuiChat(String.valueOf(prefix)));
        }
    }
}