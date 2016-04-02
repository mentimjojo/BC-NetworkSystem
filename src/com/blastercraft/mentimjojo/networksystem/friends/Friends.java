package com.blastercraft.mentimjojo.networksystem.friends;

import com.blastercraft.mentimjojo.networksystem.Main;
import com.blastercraft.mentimjojo.networksystem.core.Functions;
import com.blastercraft.mentimjojo.networksystem.core.Settings;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class Friends {

    // Main main
    Main main;

    // ItemStack skull
    public static ItemStack skull;

    /*
    * Register class
     */
    public Friends(Main plugin){
        main = plugin;
    }

    /*
    * Create player head
     */
    public static void skullHead(Player player){
        // Create item
        skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        // Get Skull meta
        SkullMeta sm = (SkullMeta) skull.getItemMeta();
        // Set owner
        sm.setOwner(player.getName());
        // Set display name
        sm.setDisplayName(Functions.stringColors("&A&LFriends"));
        // Array list string
        ArrayList<String> lore = new ArrayList<String>();
        // Lore
        lore.add(Functions.stringColors("&FHere you find all your friends and friends settings."));
        // Add lote
        sm.setLore(lore);
        // Set meta
        skull.setItemMeta(sm);
        if(!Settings.exServers.contains(Settings.pluginServerName)) {
            // Set in inventory
            player.getInventory().setItem(4, skull);
        }
    }
}
