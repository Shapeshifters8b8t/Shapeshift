package dev.is_a.acaiberii.client.cloosh.command.commands;

import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.cloosh.command.CommandBase;
import dev.is_a.acaiberii.client.cloosh.misc.util.Utils;
import dev.is_a.acaiberii.client.cloosh.module.Module;

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
