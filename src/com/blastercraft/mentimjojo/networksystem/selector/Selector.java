package com.blastercraft.mentimjojo.networksystem.selector;


import com.blastercraft.mentimjojo.networksystem.*;
import com.blastercraft.mentimjojo.networksystem.core.*;
import com.blastercraft.mentimjojo.networksystem.selector.servers.Ctf;
import com.blastercraft.mentimjojo.networksystem.selector.servers.Mobarena;
import com.blastercraft.mentimjojo.networksystem.selector.servers.Paintball;
import com.blastercraft.mentimjojo.networksystem.selector.servers.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Selector {

    // Selector item
    public static ItemStack itemSelector;

    // Selector inventory
    public static Inventory invSelector;

    /*
    * Setup selector class
     */
    public Selector(Main main){
        // Get item selector
        itemSelector = Items.createItem(Material.NAME_TAG, 1, "&B&LServer Selector", new String[]{"&FSelect the server you want to play on."});
        // Register selector events
        Functions.registerEvents(main, new Paintball(), new Survival(), new Ctf(), new Mobarena());
        // Setup inventory
        setupInventory();
        // Setup server menus
        Survival.setupMenu();
        Paintball.setupMenu();
        Ctf.setupMenu();
        Mobarena.setupMenu();
    }

    /*
    * Setup inventory
     */
    public void setupInventory(){
        // Setup inv
        invSelector = Bukkit.createInventory(null, 27, Functions.stringColors("&FSelect Server!"));
        // Add survival item
        Items.createMenuItem(invSelector, Material.DIAMOND_PICKAXE, 1, 0, "&A&LSurvival", new String[]{"&FPlay survival now with your friends", "&For complete strangers. Who cares?!"});
        // Add paintball item
        Items.createMenuItem(invSelector, Material.SNOW_BALL, 1, 2, "&A&LPaintball", new String[]{"&FCan you handle the heat of killing people", "&Fand being hunted? &F&LYes?! &FThen go play paintball now!"});
        // Add mobarena
        Items.createMenuItem(invSelector, Material.SKULL_ITEM, 1, 4, "&A&LMobarena", new String[]{"&FYour are being hunted by mobs...", "&FKill them all!"});
        // Add capturetheflag
        Items.createMenuItem(invSelector, Material.WOOL, 1, 6, "&A&LCapture The Flag", new String[]{"&FCapture the enemy's flag but watch out", "&Fthat your own flag is getting captured!"});
        // Set back to hub item when not on hub
        if(!Settings.Lobbys.contains(Settings.pluginServerName)){
            // Add back to hub item
            Items.createMenuItem(invSelector, Material.COMPASS, 1, Settings.selectorSlots-2, "&A&LBack to the hub", new String[]{"&FGo back to the hub"});
        }
        // Check if back or exit
        if(!Settings.exServers.contains(Settings.pluginServerName)) {
            // Add close item
            Items.createMenuItem(invSelector, Material.IRON_DOOR, 1, Settings.selectorSlots-1, "&A&LExit selector", new String[]{"&FExit the selector menu"});
        } else {
            // Add back item
            Items.createMenuItem(invSelector, Material.IRON_DOOR, 1, Settings.selectorSlots-1, "&A&LBack to the network menu", new String[]{"&FGo back to the network menu"});
        }
    }

    /*
    * Give selector to player
     */
    public static void giveSelector(Player player){
        // Add
        player.getInventory().setItem(0, itemSelector);
    }

    /*
    * Open menu
     */
    public static void openSelector(Player player){
        player.openInventory(invSelector);
    }
}
