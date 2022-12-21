package de.fts.battlesystem.handler;

import de.buildersinc.guitoolbox.events.EventInputHandler;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GuiHandler extends EventInputHandler {


    @Override
    public void handleEvent(Event even) {
        InventoryClickEvent event = (InventoryClickEvent) even;
        System.out.println(even.getEventName());
        event.setCancelled(true);
    }
}
