package de.fts.battlesystem;

import de.fts.battlesystem.cmd.Debug;
import de.fts.battlesystem.database.Database;
import org.bukkit.plugin.java.JavaPlugin;

public final class Battlesystem extends JavaPlugin {
    private static Battlesystem plugin;

    private Database database;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        new Debug(this);

        initDatabase();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.database.closeConnection();
    }

    public void initDatabase() {
        this.database = new Database(plugin, "players");
    }



    public static Battlesystem getPlugin() {
        return plugin;
    }

    public Database getDatabase() {
        return database;
    }
}
