package dev.is_a.acaiberii.client.cloosh.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.cloosh.command.CommandBase;
import dev.is_a.acaiberii.client.cloosh.misc.util.Utils;
import dev.is_a.acaiberii.client.cloosh.module.Module;

public class ToggleCMD extends CommandBase {
    public ToggleCMD() {
        super("toggle", "toggle <module>", "toggles a specified module", "t");
    }

    @Override
    public void onCommand(String[] args, String message) {
        if (args.length == 0) {
            sendSyntaxError();
            return;
        }

        Module targetMod = BeriiOnToppe.modManager.getMod(args[0]);

        if (targetMod == null) {
            Utils.printMSG("Could not find a module with that name");
            sendSyntaxError();
            return;
        }

        if (targetMod.isEnabled()) {
            Utils.printMSG(ChatFormatting.RED + "disabled " + ChatFormatting.RESET + targetMod.getName());
        } else {
            Utils.printMSG(ChatFormatting.GREEN + "enabled " + ChatFormatting.RESET + targetMod.getName());
        }

        targetMod.toggle();
    }
}