package com.blastercraft.mentimjojo.networksystem;

import com.blastercraft.mentimjojo.networksystem.core.Functions;
import com.blastercraft.mentimjojo.networksystem.core.Settings;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {




    /*
    * On Enable runs when running plugin
     */
    @Override
    public void onEnable(){
        // Send console message
        Functions.sendConsoleMsg("NetworkSystem By Mentimjojo (Version: " + Settings.pluginVersion + ") is Enabled.");
    }

    /*
    * On disable when server close
     */
    @Override
    public void onDisable(){
        // Send console message
        Functions.sendConsoleMsg("NetworkSystem By Mentimjojo (Version: " + Settings.pluginVersion + ") is Disabled.");
    }


}
