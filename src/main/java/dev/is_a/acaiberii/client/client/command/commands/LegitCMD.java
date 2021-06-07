package dev.is_a.acaiberii.client.client.command.commands;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.command.CommandBase;
import dev.is_a.acaiberii.client.client.misc.util.Utils;
import dev.is_a.acaiberii.client.client.module.Module;

public class LegitCMD extends CommandBase {
    public LegitCMD() {
        super("legit", "legit", "disables all modules");
    }

    @Override
    public void onCommand(String[] args, String message) {
        BeriiOnToppe.modManager.getMods().forEach(Module::disable);
        Utils.printMSG("Disabled all modules");
    }
}
