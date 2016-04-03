package com.blastercraft.mentimjojo.networksystem.networkMenu;

import com.blastercraft.mentimjojo.networksystem.core.Settings;
import com.blastercraft.mentimjojo.networksystem.friends.Friends;
import com.blastercraft.mentimjojo.networksystem.selector.Selector;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class networkMenuEvents implements Listener {

    /*
    * On player join
     */
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        // Give item
        networkMenu.giveNetworkMenuItem(event.getPlayer());
    }

    /*
    * On interact
     */
    @EventHandler
    @Deprecated
    public void onInteract(PlayerInteractEvent event){
        // Get player
        Player player = (Player) event.getPlayer();
        // Check if clicked right
        if((event.getAction() != Action.PHYSICAL) && player.getItemInHand().isSimilar(networkMenu.networkItem)){
            // Cancel event
            event.setCancelled(true);
            // Check in in
            if(Settings.exServers.contains(Settings.pluginServerName)) {
                // Setup head
                Friends.skullHead(event.getPlayer());
                // Set item friends
                networkMenu.networkInv.setItem(3, Friends.skull);
            }
            // Open menu
            player.openInventory(networkMenu.networkInv);
        }
    }

    /*
    Do things on clicking
    */
    @EventHandler
    @Deprecated
    public void onInvClick(InventoryClickEvent event) {
        // Get who clicked
        Player player = (Player) event.getWhoClicked();
        // Item clicked on
        ItemStack clickedItem = event.getCurrentItem();
        // Inventory clicked in
        Inventory clickedInventory = event.getInventory();
        // Check when clicked
        if (clickedInventory.getName().equals(networkMenu.networkInv.getName())) {
            // Cancel
            event.setCancelled(true);
            // Check if item is not null
            if (clickedItem != null) {
                if (clickedItem.getType().equals(Material.NAME_TAG)){
                    // Close inventory
                    player.closeInventory();
                    // Open selector menu
                    player.openInventory(Selector.invSelector);
                } else if(clickedItem.getType().equals(Material.SKULL_ITEM)){
                    // Close inventory
                    player.closeInventory();
                    // Open friends menu
                    Bukkit.getServer().dispatchCommand(player.getServer().getConsoleSender(), "sudo " + player.getName() + " friendsgui");
                } else if(clickedItem.getType().equals(Material.IRON_DOOR)){
                    // Close inventory
                    player.closeInventory();
                }
            }
        }
    }

    /*
    Block inventory movement
    */
    @EventHandler
    public void invClick(InventoryClickEvent event) {
        if(event.getCurrentItem() != null) {
            if (event.getCurrentItem().isSimilar(networkMenu.networkItem)) {
                event.setCancelled(true);
            }
        }
    }

    /*
    Block Drop event
    */
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if(event.getItemDrop().getItemStack().isSimilar(networkMenu.networkItem)) {
            event.setCancelled(true);
        }
    }

    /*
    Block swap player event
    */
    @EventHandler
    public void onSwapItems(PlayerSwapHandItemsEvent event) {
        // So nobody can swipe items
        if(event.getOffHandItem().isSimilar(networkMenu.networkItem)) {
            event.setCancelled(true);
        }
    }
}
