package de.fts.battlesystem.cmd;

import de.fts.battlesystem.Battlesystem;
import de.fts.battlesystem.gui.Gui;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Debug implements CommandExecutor {


    private final Battlesystem plugin;

    public Debug(Battlesystem plugin) {
        this.plugin = plugin;
        Objects.requireNonNull(plugin.getCommand("debug")).setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        player.openInventory(Gui.createChestGui(3, "Hallo", "Hallo", Material.GLASS_PANE, false, false));
        return true;
    }
}
