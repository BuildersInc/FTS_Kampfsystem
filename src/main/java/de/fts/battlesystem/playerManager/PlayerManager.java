package de.fts.battlesystem.playerManager;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.List;

public class PlayerManager implements Listener {
    private HashMap<Player, PlayerWrapper> listOfPlayer;

    public PlayerManager() {
        this.listOfPlayer = new HashMap<>();
    }

    @EventHandler
    public void joinEvent(PlayerJoinEvent event) {

    }

    public boolean loadPlayer(Player player) {
        return false;
    }
}
