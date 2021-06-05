package dev.is_a.acaiberii.client.client.module;

import dev.is_a.acaiberii.client.client.misc.util.FontUtil;
import dev.is_a.acaiberii.client.client.module.mods.chat.ChatSuffix;
import dev.is_a.acaiberii.client.client.module.mods.chat.Redtext;
import dev.is_a.acaiberii.client.client.module.mods.chat.Shrug;
import dev.is_a.acaiberii.client.client.module.mods.combat.*;
import dev.is_a.acaiberii.client.client.module.mods.misc.*;
import dev.is_a.acaiberii.client.client.module.mods.movement.*;
import dev.is_a.acaiberii.client.client.module.mods.render.*;
import dev.is_a.acaiberii.client.client.module.mods.tests.PacketTests;
import dev.is_a.acaiberii.client.client.module.mods.world.BuildHeight;
import dev.is_a.acaiberii.client.client.module.mods.world.NoRotate;
import dev.is_a.acaiberii.client.client.module.mods.world.Timer;
import dev.is_a.acaiberii.client.client.module.mods.chat.*;
import dev.is_a.acaiberii.client.client.module.mods.combat.*;
import dev.is_a.acaiberii.client.client.module.mods.misc.*;
import dev.is_a.acaiberii.client.client.module.mods.movement.*;
import dev.is_a.acaiberii.client.client.module.mods.render.*;
import dev.is_a.acaiberii.client.client.module.mods.tests.ChatTests;
import dev.is_a.acaiberii.client.client.module.mods.world.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleManager {

    public ModuleManager() {
        init();
    }

    ArrayList<Module> modules = new ArrayList<>();

    public ArrayList<Module> sortedMods = new ArrayList<>();

    private void init() {
        // combat
        registerMod(new AutoCrystal());
        registerMod(new AutoTotem());
        registerMod(new Criticals());
        registerMod(new FastUtil());
        registerMod(new KillAura());
        registerMod(new Offhand());
        registerMod(new AutoEZ());
        registerMod(new Burrow());

        // render
        registerMod(new BlockOutline());
        registerMod(new ESP());
        registerMod(new Freecam());
        registerMod(new Fullbright());
        registerMod(new NameTags());
        registerMod(new NoRender());
        registerMod(new NoWeather());
        registerMod(new ViewModel());
        registerMod(new Wallhack());
        registerMod(new XRay());

        // movement
        registerMod(new AutoWalk());
        registerMod(new NoFall());
        registerMod(new NoSlow());
        registerMod(new SafeWalk());
        registerMod(new Sprint());
        registerMod(new Step());
        registerMod(new Velocity());

        // world
        registerMod(new BuildHeight());
        registerMod(new NoRotate());
        registerMod(new Timer());

        // misc
        registerMod(new AntiCrash());
        registerMod(new DiscordRPC());
        registerMod(new ClickGUI());
        registerMod(new CustomFont());
        registerMod(new HudEditor());
        registerMod(new ClickGUIOld());
        registerMod(new PacketEXP());

        // chat
        registerMod(new Redtext());
        registerMod(new ChatSuffix());
        registerMod(new Shrug());

        // tests
        registerMod(new ChatTests());
        registerMod(new PacketTests());

        modules.sort(this::compareTo);

        sortedMods.addAll(modules);
        sortedMods.sort(this::compareLength);
    }

    // alphabetical sort
    private int compareTo(Module mod1, Module mod2) {
        return mod1.getName().compareTo(mod2.getName());
    }

    private int compareLength(Module mod1, Module mod2) {
        return Integer.compare(FontUtil.getStringWidth(mod1.getName()), FontUtil.getStringWidth(mod2.getName()));
    }

    private void registerMod(Module m) {
        modules.add(m);
    }

    public Module getMod(String name) {
        return modules.stream().filter(mod -> mod.name.equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public List<Module> getModsByCategory(Category category) {
        return modules.stream().filter(mod -> mod.category == category).collect(Collectors.toList());
    }

    public ArrayList<Module> getMods() {
        return modules;
    }
}
