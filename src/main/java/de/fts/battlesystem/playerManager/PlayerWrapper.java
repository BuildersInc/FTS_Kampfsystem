package de.fts.battlesystem.playerManager;

import de.fts.battlesystem.enums.Race;
import de.fts.battlesystem.index.StatsIndex;
import org.bukkit.entity.Player;

import java.util.HashMap;


public class PlayerWrapper {
    private Player player;
    private Race race;
    private final HashMap<String, Integer> stats;

    public PlayerWrapper(Player player, Race race) {
        this.player = player;
        this.race = race;

        this.stats = new HashMap<>();
    }

    public Player getPlayer() {
        return player;
    }
    public Race getRace() {
        return race;
    }

    public int getRangePoints() {
        return stats.get("range");
    }
    public void setRangePoints(int value) {
        stats.put("range", value);
    }
    public int getHeartPoints() {
        return stats.get("hp");
    }

    public void setHeartPoints(int value) {
        stats.put("hp", value);
    }

    public int getMeleePoints() {
        return stats.get("melee");
    }

    public void setMeleePoints(int value) {
        stats.put("melee", value);

    }

    public int getAgilityPoints() {
        return stats.get("agility");

    }

    public void setAgilityPoints(int value) {
        stats.put("agility", value);

    }

    public int getMagicPoints() {
        return stats.get("magic");
    }

    public void setMagicPoints(int value) {
        stats.put("magic", value);
    }
    
}
