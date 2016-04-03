package com.blastercraft.mentimjojo.networksystem.selector;

import com.blastercraft.mentimjojo.networksystem.Main;
import com.blastercraft.mentimjojo.networksystem.core.*;
import com.blastercraft.mentimjojo.networksystem.networkMenu.networkMenu;
import com.blastercraft.mentimjojo.networksystem.selector.servers.Ctf;
import com.blastercraft.mentimjojo.networksystem.selector.servers.Paintball;
import com.blastercraft.mentimjojo.networksystem.selector.servers.Survival;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class selectorEvents implements Listener {

    // Main main;
    Main main;

    public selectorEvents(Main plugin){
        this.main = plugin;
    }

    /*
    * On player join
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(!Settings.exServers.contains(Settings.pluginServerName)){
            // Give selector item
            Selector.giveSelector(event.getPlayer());
        }
    }


    /*
    * On player inventory click
     */
    @EventHandler
    @Deprecated
    public void onPlayerInteract(PlayerInteractEvent event){
        // Get player
        Player player = event.getPlayer();
        if(!Settings.exServers.contains(Settings.pluginServerName)) {
            // Check if selector item
            if ((event.getAction() != Action.PHYSICAL) && player.getItemInHand().isSimilar(Selector.itemSelector)) {
                // Cancel event
                event.setCancelled(true);
                // Open menu
                Selector.openSelector(player);
            }
        }
    }

    /*
    * On click in inventory
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        // Get who clicked
        Player player = (Player) event.getWhoClicked();
        // Item clicked on
        ItemStack clickedItem = event.getCurrentItem();
        // Inventory clicked in
        Inventory clickedInventory = event.getInventory();
        // Check if clicked in selector inventory
        if (clickedInventory.getName().equals(Selector.invSelector.getName())) {
            // Cancel event
            event.setCancelled(true);
            // Check if not null
            if (clickedItem != null) {
                // Check what clicked
                if (clickedItem.getType() == Material.DIAMOND_PICKAXE) {
                    // Close inventory
                    player.closeInventory();
                    // Open servers
                    Survival.openMenu(player);
                } else if (clickedItem.getType() == Material.SNOW_BALL) {
                    // Close inventory
                    player.closeInventory();
                    // Open servers
                    Paintball.openMenu(player);
                } else if (clickedItem.getType() == Material.SKULL_ITEM) {
                    // Close selector
                    player.closeInventory();
                    // Send message to player disabled
                    Functions.sendPlayerMsg(player, "&CMobarena is closed.");
                } else if (clickedItem.getType() == Material.WOOL) {
                    // Close selector
                    player.closeInventory();
                    // Open servers
                    Ctf.openMenu(player);
                } else if(clickedItem.getType() == Material.COMPASS){
                    // Close inventory
                    player.closeInventory();
                    // Back to hub
                    Channels.teleportToServer(player, "We are sending you to the hub.", Functions.getRandomLobby());
                } else if (clickedItem.getType() == Material.IRON_DOOR) {
                    // Close selector
                    player.closeInventory();
                    // Check if back
                    if(Settings.exServers.contains(Settings.pluginServerName)) {
                        player.openInventory(networkMenu.networkInv);
                    }
                }
            }
        }
    }
}
