package dev.is_a.acaiberii.client.client.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import dev.is_a.acaiberii.client.BeriiOnToppe;
import dev.is_a.acaiberii.client.client.command.CommandBase;
import dev.is_a.acaiberii.client.client.misc.util.Utils;

public class ModulesCMD extends CommandBase {
    public ModulesCMD() {
        super("modules", "modules", "shows all modules", "mods");
    }

    @Override
    public void onCommand(String[] args, String message) {
        StringBuilder sb = new StringBuilder();


        BeriiOnToppe.modManager.getMods().forEach(module -> {
            if (module.isEnabled()) {
                sb.append(ChatFormatting.GREEN + module.getName() + ChatFormatting.WHITE + ", ");
            } else {
                sb.append(ChatFormatting.RED + module.getName() + ChatFormatting.WHITE + ", ");
            }
        });

        Utils.printMSG("Modules: " + sb.substring(0, sb.length() - 2));
    }
}