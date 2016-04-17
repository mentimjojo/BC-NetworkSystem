package com.blastercraft.mentimjojo.networksystem.networkMenu;

import com.blastercraft.mentimjojo.networksystem.Main;
import com.blastercraft.mentimjojo.networksystem.core.Functions;
import com.blastercraft.mentimjojo.networksystem.core.Items;
import com.blastercraft.mentimjojo.networksystem.friends.Friends;
import com.blastercraft.mentimjojo.networksystem.selector.Selector;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class networkMenu {

    // Main
    Main main;

    // ItemStack item
    public static ItemStack networkItem;

    // Create network menu
    public static Inventory networkInv;

    /*
    Register class
     */
    public networkMenu(Main plugin){
        // Get main
        main = plugin;
        // Setup item
        networkItem = Items.createItem(Material.EMERALD, 1, "&A&LNetwork Menu", new String[]{ "&FThe network menu item." });
        // Create menu
        networkInv = Bukkit.createInventory(null, 18, Functions.stringColors("&FNetwork menu"));
        // Setup items
        createMenuItems();
    }

    private static void createMenuItems(){
        // Set item selector
        networkInv.setItem(1, Selector.itemSelector);
        // Set item selector
        Items.createMenuItem(networkInv, Material.IRON_DOOR, 1, 17, "&A&LClose network menu", new String[]{ "&FClose the network menu." });
    }

    /*
    Give network menu item
     */
    public static void giveNetworkMenuItem(Player player){
        // Give item
        player.getInventory().setItem(8, networkItem);
    }

}
