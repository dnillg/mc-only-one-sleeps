package com.dgiczi.mc.furnaceplugin;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class SoloSleep extends JavaPlugin {

    @Override
    public void onEnable() {
        final Logger logger = getLogger();
        final Server server = getServer();
        final PlayerSleepListener listener = new PlayerSleepListener(this);
        server.getPluginManager().registerEvents(listener, this);

        logger.info("solo-sleep enabled...");

        super.onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().info("solo-sleep disabled...");
        super.onDisable();
    }
}
