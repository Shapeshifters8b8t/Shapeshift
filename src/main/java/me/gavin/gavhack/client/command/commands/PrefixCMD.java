package me.gavin.gavhack.client.command.commands;

import me.gavin.gavhack.BeriiOnToppe;
import me.gavin.gavhack.client.command.CommandBase;
import me.gavin.gavhack.client.misc.util.Utils;

public class PrefixCMD extends CommandBase {
    public PrefixCMD() {
        super("prefix", "prefix <char>", "sets the char to activate commands");
    }

    @Override
    public void onCommand(String[] args, String message) {
        if (args.length == 0) {
            sendSyntaxError();
            return;
        }

        if (args[0].length() > 1) {
            Utils.printMSG("Prefix must be 1 character long");
            sendSyntaxError();
            return;
        }

        char newPrefix = args[0].charAt(0);

        BeriiOnToppe.commandManager.prefix = newPrefix;
        Utils.printMSG("Set the command prefix to " + newPrefix);
    }
}