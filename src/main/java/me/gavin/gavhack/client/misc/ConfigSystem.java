package me.gavin.gavhack.client.misc;

import me.gavin.gavhack.BeriiOnToppe;
import me.gavin.gavhack.client.setting.impl.BooleanSetting;
import me.gavin.gavhack.client.setting.impl.KeyBindSetting;
import me.gavin.gavhack.client.setting.impl.ModeSetting;
import me.gavin.gavhack.client.setting.impl.NumberSetting;
import net.minecraft.client.Minecraft;
import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.*;

public class ConfigSystem extends Thread {

    Minecraft mc = Minecraft.getMinecraft();

    File dataFolder = new File(mc.mcDataDir, BeriiOnToppe.MODID);
    File modFolder = new File(mc.mcDataDir, BeriiOnToppe.MODID + "/mods/");

    public ConfigSystem() {
        makeFolder();
    }

    void makeFolder() {
        if (!dataFolder.exists())
            dataFolder.mkdir();

        if (!modFolder.exists())
            modFolder.mkdir();
    }

    BufferedWriter writer;

    public void saveModulesAndSettings() {
        makeFolder();
        BeriiOnToppe.modManager.getMods().forEach(module -> {
            JSONObject moduleObj = new JSONObject();
            moduleObj.put("enabled", module.isEnabled());

            module.settings.forEach(setting -> {
                if (setting instanceof BooleanSetting) {
                    moduleObj.put(setting.name, ((BooleanSetting) setting).isEnabled());
                } else if (setting instanceof KeyBindSetting) {
                    moduleObj.put(setting.name, ((KeyBindSetting) setting).getKeyCode());
                } else if (setting instanceof ModeSetting) {
                    moduleObj.put(setting.name, ((ModeSetting) setting).getMode());
                } else if (setting instanceof NumberSetting) {
                    moduleObj.put(setting.name, ((NumberSetting) setting).getValue());
                }
            });

            try {
                writer = new BufferedWriter(new FileWriter(new File(modFolder,  module.getName() + ".json")));
                writer.write(moduleObj.toJSONString());
                writer.close();
            } catch (IOException e) { e.printStackTrace(); }
        });
    }

    BufferedReader reader;
    JSONParser parser = new JSONParser();

    public void loadModulesAndSettings() {
        makeFolder();
        BeriiOnToppe.modManager.getMods().forEach(module -> {
            try {
                reader = new BufferedReader(new FileReader(new File(modFolder, module.getName() + ".json")));

                JSONObject parsedModule = (JSONObject) parser.parse(reader);

                if ((boolean) parsedModule.get("enabled"))
                    module.toggle();


                // have to get integer values out of longs because json-simple is odd
                module.settings.forEach(setting -> {
                    if (parsedModule.containsKey(setting.name)) {
                        if (setting instanceof BooleanSetting) {
                            ((BooleanSetting) setting).setEnabled((boolean) parsedModule.get(setting.name));
                        } else if (setting instanceof KeyBindSetting) {
                            Long value = (long) parsedModule.get(setting.name);
                            ((KeyBindSetting) setting).setKeyCode(value.intValue());
                        } else if (setting instanceof ModeSetting) {
                            ((ModeSetting) setting).setMode((String) parsedModule.get(setting.name));
                        } else if (setting instanceof NumberSetting) {
                            double value = (double) parsedModule.get(setting.name);
                            ((NumberSetting) setting).setValue(value);
                        }
                    }
                });

            } catch (IOException | ParseException e) { e.printStackTrace(); }
        });
    }

    public void saveOtherValues() {
        makeFolder();

        // command prefix
        try {
            File file = new File(dataFolder, "prefix.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(BeriiOnToppe.commandManager.prefix);
            writer.close();
        } catch (IOException e) { e.printStackTrace(); }
    }

    public void loadOtherValues() {
        makeFolder();

        // command prefix
        try {
            File file = new File(dataFolder, "prefix.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            BeriiOnToppe.commandManager.prefix = reader.readLine().charAt(0);
        } catch (IOException e) { e.printStackTrace(); }
    }

    // called on client shutdown
    @Override
    public void run() {
        saveModulesAndSettings();
        saveOtherValues();
    }
}
