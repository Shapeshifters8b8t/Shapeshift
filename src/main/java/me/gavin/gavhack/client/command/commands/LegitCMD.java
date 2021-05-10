package me.gavin.gavhack.client.command.commands;

import me.gavin.gavhack.BeriiOnToppe;
import me.gavin.gavhack.client.command.CommandBase;
import me.gavin.gavhack.client.misc.util.Utils;
import me.gavin.gavhack.client.module.Module;

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
