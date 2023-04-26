package de.fts.battlesystem.gui;

import de.fts.battlesystem.Battlesystem;
import dev.dbassett.skullcreator.SkullCreator;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

public class Items {
    /**
     * Creates a Placeholder Item that is just there to block a slot
     * @param material the Item material that is used
     * @param nameSpace the customStringId of the Item
     * @param glint the item is shining
     * @return the modified Item
     */
    public static ItemStack nonAirPlaceholder(Material material, String nameSpace, boolean glint ) {
        NamespacedKey key = new NamespacedKey(Battlesystem.getPlugin(), nameSpace);
        ItemStack itemStack = new ItemStack(material);

        ItemMeta meta = itemStack.getItemMeta();
        meta.displayName(Component.text(" "));
        if (glint) {
            meta.addEnchant(Enchantment.MENDING, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "placeHolder");
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    /**
     * Creates a playerhead without info linked to the Player
     * @param keyString keyName in Namespace ServerCore
     * @param label Name of the Item
     * @param url Minecraft texture url of the Head
     * @param id CustomID to identify
     * @return customhead
     */
    public static ItemStack createItem(String keyString, String label, String url, String id) {
        Component name = Component.text(label);

        NamespacedKey key = new NamespacedKey(Battlesystem.getPlugin(), keyString);
        ItemStack item = SkullCreator.itemFromUrl("http://textures.minecraft.net/texture/" + url);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.displayName(name);
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, id);
        item.setItemMeta(meta);
        return item;
    }
    /**
     * Creates an Item Without Values attached to player Info
     * @param keyString keyName in Namespace ServerCore
     * @param label Name of the Item
     * @param material material of the Item
     * @param id CustomID to identify
     * @param glint item glows
     * @return created Item
     */
    public static ItemStack createItem(String keyString, String label, Material material, String id, boolean glint) {
        NamespacedKey key = new NamespacedKey(Battlesystem.getPlugin(), keyString);
        Component name = Component.text(label);
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        meta.displayName(name);

        if (glint) {
            meta.addEnchant(Enchantment.MENDING, 1, true);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }

        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, id);
        item.setItemMeta(meta);

        return item;

    }
}
