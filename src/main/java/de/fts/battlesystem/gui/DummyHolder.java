package de.fts.battlesystem.gui;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

/**
 * <pre>
 * Custom holder in order to identify a custom inventory
 * ==> if (inv.getHolder() instance of DummyHolder)
 *          ==> True -> Inventory is custom
 *          ==> False -> Inventory is not Custom
 * </pre>
 */
public class DummyHolder implements InventoryHolder {

    @Override
    public Inventory getInventory() {
        return null;
    }
}