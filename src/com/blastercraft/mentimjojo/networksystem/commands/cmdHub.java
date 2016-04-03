package com.blastercraft.mentimjojo.networksystem.commands;

import com.blastercraft.mentimjojo.networksystem.core.Channels;
import com.blastercraft.mentimjojo.networksystem.core.Functions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class cmdHub implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            // Get player
            Player player = (Player) sender;

            // Send back to hub
            Channels.teleportToServer(player, "We are sending you back to the hub.", Functions.getRandomLobby());
        }
        // When nothing
        return true;
    }

}
