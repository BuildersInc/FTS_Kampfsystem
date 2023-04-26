package de.fts.battlesystem;

import de.fts.battlesystem.cmd.Debug;
import org.bukkit.plugin.java.JavaPlugin;

public final class Battlesystem extends JavaPlugin {
    private static Battlesystem plugin;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        new Debug(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Battlesystem getPlugin() {
        return plugin;
    }
}
