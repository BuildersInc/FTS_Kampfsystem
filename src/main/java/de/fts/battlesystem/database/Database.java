package de.fts.battlesystem.database;


import de.fts.battlesystem.playerManager.PlayerWrapper;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.sql.*;

public class Database {
    private Connection dataBaseConnection;
    private Plugin plugin;

    public Database(Plugin plugin, String databaseName) {
        this.plugin = plugin;
        if (!plugin.getDataFolder().exists()) plugin.getDataFolder().mkdirs();
        try {
            this.dataBaseConnection = DriverManager.getConnection("jdbc:sqlite:" + plugin.getDataFolder() + "/" + databaseName + ".db");
            Statement statement = this.dataBaseConnection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS players (id INTEGER PRIMARY KEY," +
                    " UUID TEXT," +
                    " RACE TEXT," +
                    " statMelee INTEGER," +
                    " statRange INTEGER," +
                    " statAgility INTEGER," +
                    " statMagic INTEGER," +
                    " statHP INTEGER)";
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void closeConnection() {
        try {
            this.dataBaseConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void savePlayerToDatabase(PlayerWrapper player) {
        String sql = "INSERT INTO players (UUID, RACE, statMelee, statRange, statAgility, statMagic, statHP) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = this.dataBaseConnection.prepareStatement(sql);
            stmt.setString(1, player.getPlayer().getUniqueId().toString());
            stmt.setString(2, player.getRace().name());
            stmt.setInt(3, player.getMeleePoints());
            stmt.setInt(4, player.getRangePoints());
            stmt.setInt(5, player.getAgilityPoints());
            stmt.setInt(6, player.getMagicPoints());
            stmt.setInt(7, player.getHeartPoints());

            // Execute the prepared statement to insert the data
            int rowsInserted = stmt.executeUpdate();
            System.out.println("Speichern : " + rowsInserted);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
