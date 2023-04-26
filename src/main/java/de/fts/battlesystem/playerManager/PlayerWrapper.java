package de.fts.battlesystem.playerManager;

import de.fts.battlesystem.enums.Race;
import de.fts.battlesystem.index.StatsIndex;
import org.bukkit.entity.Player;


public class PlayerWrapper {
    private Player player;
    private Race race;
    private final int[] stats;

    public PlayerWrapper(Player player, Race race) {
        this.player = player;
        this.race = race;
        this.stats = new int[4];
    }

    public int getHeartPoints() {
        return getStat(StatsIndex.HEART_POINTS.ordinal());
    }

    public void setHeartPoints(int value) {
        setStat(StatsIndex.HEART_POINTS.ordinal(), value);
    }

    public int getMeleePoints() {
        return getStat(StatsIndex.MELEE.ordinal());
    }

    public void setMeleePoints(int value) {
        setStat(StatsIndex.MELEE.ordinal(), value);
    }

    public int getAgilityPoints() {
        return getStat(StatsIndex.AGILITY.ordinal());
    }

    public void setAgilityPoints(int value) {
        setStat(StatsIndex.AGILITY.ordinal(), value);
    }

    public int getMagicPoints() {
        return getStat(StatsIndex.MAGIC.ordinal());
    }

    public void setMagicPoints(int value) {
        setStat(StatsIndex.MAGIC.ordinal(), value);
    }

    private int getStat(int statIndex) {
        return stats[statIndex];
    }

    private void setStat(int statIndex, int value) {
        this.stats[statIndex] = value;
    }

}
