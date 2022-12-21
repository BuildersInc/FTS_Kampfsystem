package de.fts.battlesystem;

import de.buildersinc.guitoolbox.main.GuiBuilder;
import de.buildersinc.guitoolbox.toolBox.GuiToolbox;
import de.fts.battlesystem.cmd.Debug;
import de.fts.battlesystem.handler.GuiHandler;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Battlesystem extends JavaPlugin {

    private GuiBuilder guiBuilder;
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.guiBuilder = new GuiBuilder(this, new GuiHandler());
        new Debug(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public GuiToolbox getGuiToolbox() {
        return guiBuilder.getGuiToolbox();
    }
}
