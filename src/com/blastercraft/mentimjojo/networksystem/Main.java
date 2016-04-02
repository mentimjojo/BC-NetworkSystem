package com.blastercraft.mentimjojo.networksystem;

import com.blastercraft.mentimjojo.networksystem.core.*;
import com.blastercraft.mentimjojo.networksystem.selector.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    // Selector
    Selector selector;

    // Channels
    Channels channels;

    /*
    * On Enable runs when running plugin
     */
    @Override
    public void onEnable(){
        // Register BungeeCord channel
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        // Get plugin yml
        Functions.startupFunctions(this);
        // Setup channels
        channels = new Channels(this);
        // Setup selector
        selector = new Selector(this);
        // Send console message
        Functions.sendConsoleMsg("NetworkSystem By Mentimjojo (Version: " + Settings.pluginVersion + ") is Enabled on Server : " + Settings.pluginServerName);
    }

    /*
    * On disable when server close
     */
    @Override
    public void onDisable(){
        // Send console message
        Functions.sendConsoleMsg("NetworkSystem By Mentimjojo (Version: " + Settings.pluginVersion + ") is Disabled on Server : " + Settings.pluginServerName);
    }

}
