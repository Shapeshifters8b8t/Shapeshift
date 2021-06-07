package dev.is_a.acaiberii.client.client.command.commands;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.command.CommandBase;
import dev.is_a.acaiberii.client.client.misc.util.Utils;

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