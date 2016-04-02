package com.blastercraft.mentimjojo.networksystem.core;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Items {

    /*
    * Create item with ItemStack
     */
    public static ItemStack createItem(Material material, int count, String displayName, String[] lores) {
        // Item
        ItemStack item = new ItemStack(material, count);
        // item meta
        ItemMeta meta = item.getItemMeta();
        // Set display name
        meta.setDisplayName(Functions.stringColors(displayName));
        // Array list lores
        ArrayList<String> lore = new ArrayList<String>();
        // Foreach lore
        for (String l : lores) {
            lore.add(Functions.stringColors(l));
        }
        // Add lores
        meta.setLore(lore);
        // Set meta
        item.setItemMeta(meta);
        // Return item
        return item;
    }

    /*
    * Create inside menu item
     */
    public static void createMenuItem(Inventory menu, Material material, int count, int slot, String displayName, String[] lores){
        // Create item
        ItemStack item = new ItemStack(material, count);
        // Item meta
        ItemMeta meta = item.getItemMeta();
        // Set display name
        meta.setDisplayName(Functions.stringColors(displayName));
        // Array list string
        ArrayList<String> lore = new ArrayList<String>();
        // Foreach lore
        for(String l : lores){
            lore.add(Functions.stringColors(l));
        }
        // Add lote
        meta.setLore(lore);
        // Set meta
        item.setItemMeta(meta);
        // Add to selector
        menu.setItem(slot, item);
    }

}
