package com.blastercraft.mentimjojo.networksystem.core;

import com.blastercraft.mentimjojo.networksystem.Main;
import org.bukkit.entity.Player;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

public class Channels {

    // Get Main
    static Main main;

    // Register class
    public Channels(Main plugin){
        main = plugin;
    }

    public static void teleportToServer( Player player, String msg, String Server){
        // Send player message to send
        Functions.sendPlayerMsg(player, msg);
        // Send server
        try{
            // Byte array
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            // Data output
            DataOutputStream out = new DataOutputStream(b);
            // Out connect
            out.writeUTF("Connect");
            // To server
            out.writeUTF(Server);
            // Send plugin message
            player.sendPluginMessage(main, "BungeeCord", b.toByteArray());
            // Close b
            b.close();
            // close out
            out.close();
        } catch (Exception ex){
            // Nothing
        }
    }

}
