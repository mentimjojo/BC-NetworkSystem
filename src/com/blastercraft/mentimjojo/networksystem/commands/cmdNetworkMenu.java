package com.blastercraft.mentimjojo.networksystem.commands;

import com.blastercraft.mentimjojo.networksystem.core.Functions;
import com.blastercraft.mentimjojo.networksystem.selector.Selector;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdNetworkMenu implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            // Get player
            Player player = (Player) sender;
            // Sending message
            Functions.sendPlayerMsg(player, "Opening the selector.");
            // Open network menu
            player.openInventory(Selector.invSelector);
        }
        return true;
    }

}
