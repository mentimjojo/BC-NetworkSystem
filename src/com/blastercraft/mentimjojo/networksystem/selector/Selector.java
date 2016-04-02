package com.blastercraft.mentimjojo.networksystem.selector;


import com.blastercraft.mentimjojo.networksystem.*;
import com.blastercraft.mentimjojo.networksystem.core.*;
import com.blastercraft.mentimjojo.networksystem.selector.servers.Ctf;
import com.blastercraft.mentimjojo.networksystem.selector.servers.Paintball;
import com.blastercraft.mentimjojo.networksystem.selector.servers.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Selector {

    // Selector item
    static ItemStack itemSelector;

    // Selector inventory
    public static Inventory invSelector;

    /*
    * Setup selector class
     */
    public Selector(Main main){
        // Get item selector
        itemSelector = Items.createItem(Material.NAME_TAG, 1, "&B&LServer Selector", new String[]{"&FSelect the server you want to play on."});
        // Register selector events
        Functions.registerEvents(main, new Events(main), new Paintball(), new Survival(), new Ctf());
        // Setup inventory
        setupInventory();
        // Setup server menus
        Survival.setupMenu();
        Paintball.setupMenu();
        Ctf.setupMenu();
    }

    /*
    * Setup inventory
     */
    public void setupInventory(){
        // Setup inv
        invSelector = Bukkit.createInventory(null, 54, Functions.stringColors("&FSelect Server!"));
        // Add survival item
        Items.createMenuItem(invSelector, Material.DIAMOND_PICKAXE, 1, 1, "&A&LSurvival", new String[]{"&FPlay survival now with your friends", "&For complete strangers. Who cares?!"});
        // Add paintball item
        Items.createMenuItem(invSelector, Material.SNOW_BALL, 1, 3, "&A&LPaintball", new String[]{"&FCan you handle the heat of killing people", "&Fand being hunted? &F&LYes?! &FThen go play paintball now!"});
        // Add mobarena
        Items.createMenuItem(invSelector, Material.SKULL_ITEM, 1, 5, "&A&LMobarena", new String[]{"&FYour are being hunted by mobs...", "&FKill them all!"});
        // Add capturetheflag
        Items.createMenuItem(invSelector, Material.WOOL, 1, 7, "&A&LCapture The Flag", new String[]{"&FCapture the enemy's flag but watch out", "&Fthat your own flag is getting captured!"});
        // Add close item
        Items.createMenuItem(invSelector, Material.IRON_DOOR, 1, 53, "&A&LExit selector", new String[]{"&FExit the selector menu"});
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
