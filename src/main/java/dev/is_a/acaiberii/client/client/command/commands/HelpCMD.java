package dev.is_a.acaiberii.client.client.command.commands;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.command.CommandBase;
import dev.is_a.acaiberii.client.client.misc.util.Utils;

public class HelpCMD extends CommandBase {
    public HelpCMD() {
        super("help", "help", "shows all commands");
    }

    @Override
    public void onCommand(String[] args, String message) {

        StringBuilder sb = new StringBuilder();
        for (CommandBase commandBase : BeriiOnToppe.commandManager.getCommands()) {
            sb.append(commandBase.getName().concat(", "));
        }

        String cmds = sb.substring(0, sb.length() - 2);

        Utils.printMSG("Commands: " + cmds);
    }
}