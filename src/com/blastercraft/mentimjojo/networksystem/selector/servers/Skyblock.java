package com.blastercraft.mentimjojo.networksystem.selector.servers;

import com.blastercraft.mentimjojo.networksystem.core.*;
import com.blastercraft.mentimjojo.networksystem.selector.Selector;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Skyblock {

    // Create survival menuCore
    private static Inventory menu;

    // Setup survival
    public static void setupMenu() {
        // Create menuCore
        menu = Bukkit.createInventory(null, 18, ChatColor.translateAlternateColorCodes('&', "Select Skyblock Server"));
        // Create server 1
        Items.createMenuItem(menu, Material.EMERALD_BLOCK, 1, 0,  "Server 1", new String[]{"&6Skyblock server 1"});
        Items.createMenuItem(menu, Material.IRON_DOOR, 1, 17, "&A&LBack", new String[]{"&FBack to the selector"});
    }

    public static void openMenu(Player player) {
        // Open menuCore
        player.openInventory(menu);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // Get who clicked
        Player player = (Player) event.getWhoClicked();
        // Item clicked on
        ItemStack clickedItem = event.getCurrentItem();
        // Inventory clicked in
        Inventory clickedInventory = event.getInventory();
        // Check if clicked in selector inventory
        if (clickedInventory.getName().equals(menu.getName())) {
            if (clickedItem != null) {
                if (clickedItem.getType() == Material.EMERALD_BLOCK) {
                    // Cancel event
                    event.setCancelled(true);
                    // Close inventory
                    player.closeInventory();
                    // Send to right server
                    if (clickedItem.getItemMeta().getDisplayName().equals("Server 1")) {
                        Channels.teleportToServer(player, "We are sending you to Skyblock-1", "skyblock-1");
                    }
                } else if (clickedItem.getType() == Material.IRON_DOOR) {
                    // Cancel event
                    event.setCancelled(true);
                    // Open selector
                    Selector.openSelector(player);
                }
            }
        }
    }


}
