package com.blastercraft.mentimjojo.networksystem.toggler;

import com.blastercraft.mentimjojo.networksystem.Main;
import com.blastercraft.mentimjojo.networksystem.core.Functions;
import com.blastercraft.mentimjojo.networksystem.core.Items;
import com.blastercraft.mentimjojo.networksystem.core.Settings;
import com.blastercraft.mentimjojo.networksystem.selector.*;
import com.blastercraft.mentimjojo.networksystem.selector.Events;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Toggler {

    // Main
    Main main;

    // ItemStack hide/show
    public static ItemStack hideItem, showItem;

    // Cooldown
    static ArrayList<Player> cooldown = new ArrayList<Player>();

    // Boolean hide/show
    static boolean visible = true;

    public Toggler(Main plugin) {
        // Main
        this.main = plugin;
        // Hide
        setupHide();
        // Show
        setupShow();
        // Register event
        Functions.registerEvents(main, new com.blastercraft.mentimjojo.networksystem.toggler.Events(main));
    }

    public static void setupHide() {
        // Get item stack
        hideItem = new ItemStack(Material.SLIME_BALL, 1);
        // Get item meta
        ItemMeta meta = hideItem.getItemMeta();
        // Set display name
        meta.setDisplayName(Functions.stringColors("&C&LHide players"));
        // Array list lores
        ArrayList<String> lore = new ArrayList<String>();
        // Set lore
        lore.add(Functions.stringColors("&FHide all the players"));
        lore.add(" ");
        lore.add(Functions.stringColors("&CAfter your used this tool you have to wait 5 seconds."));
        // Set the lore
        meta.setLore(lore);
        // Set the meta
        hideItem.setItemMeta(meta);
    }

    public static void setupShow() {
        // Get item stack
        showItem = new ItemStack(Material.MAGMA_CREAM, 1);
        // Get item meta
        ItemMeta meta = showItem.getItemMeta();
        // Set display name
        meta.setDisplayName(Functions.stringColors("&A&LShow players"));
        // Array list lores
        ArrayList<String> lore = new ArrayList<String>();
        // Set lore
        lore.add(Functions.stringColors("&FShow all the players"));
        lore.add(" ");
        lore.add(Functions.stringColors("&CAfter your used this tool you have to wait 5 seconds."));
        // Set the lore
        meta.setLore(lore);
        // Set the meta
        showItem.setItemMeta(meta);
    }

    // Give hide
    public static void giveHideItem(Player player) {
        // Give item
        player.getInventory().setItem(8, hideItem);
    }

    // Give show
    public static void giveShowItem(Player player) {
        // Give item
        player.getInventory().setItem(8, showItem);
    }
}
