package me.gavin.gavhack.client.command.commands;

import me.gavin.gavhack.BeriiOnToppe;
import me.gavin.gavhack.client.command.CommandBase;
import me.gavin.gavhack.client.misc.util.Utils;
import me.gavin.gavhack.client.module.Module;
import org.lwjgl.input.Keyboard;

public class BindCMD extends CommandBase {
    public BindCMD() {
        super("bind", "bind <module> <key>", "binds a module to the specified key", "b");
    }

    @Override
    public void onCommand(String[] args, String message) {
        if (args.length == 2) {
            Module targetMod = BeriiOnToppe.modManager.getMod(args[0]);
            String keyName = args[1].toUpperCase();

            if (targetMod != null) {
                targetMod.keyBind.setKeyCode(Keyboard.getKeyIndex(keyName));
                Utils.printMSG("Bound " + targetMod.getName() + " to " + keyName);
                return;
            } else {
                Utils.printMSG("Unable to find the specified module");
                sendSyntaxError();
                return;
            }
        } else {
            sendSyntaxError();
            return;
        }
    }
}