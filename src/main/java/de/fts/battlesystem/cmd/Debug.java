package de.fts.battlesystem.cmd;

import de.fts.battlesystem.Battlesystem;
import de.fts.battlesystem.enums.Race;
import de.fts.battlesystem.gui.Gui;
import de.fts.battlesystem.playerManager.PlayerWrapper;
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
        PlayerWrapper playerWrapper = new PlayerWrapper(player, Race.HUMAN);
        playerWrapper.setRangePoints(5);
        playerWrapper.setHeartPoints(6);
        playerWrapper.setMagicPoints(7);
        playerWrapper.setMeleePoints(9);
        playerWrapper.setAgilityPoints(10);
        plugin.getDatabase().savePlayerToDatabase(playerWrapper);
        player.openInventory(Gui.createChestGui(3, "Hallo", "Hallo", Material.GLASS_PANE, false, false));
        return true;
    }
}
