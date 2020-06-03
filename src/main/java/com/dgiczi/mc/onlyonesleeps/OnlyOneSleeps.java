package com.dgiczi.mc.onlyonesleeps;

import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class OnlyOneSleeps extends JavaPlugin {

    @Override
    public void onEnable() {
        final Logger logger = getLogger();
        final Server server = getServer();
        final PlayerSleepListener listener = new PlayerSleepListener(this);

        setConfigDefaults();
        getConfig().options().copyDefaults(true);
        saveConfig();

        server.getPluginManager().registerEvents(listener, this);
        logger.info("only-one-sleeps enabled...");
        super.onEnable();
    }

    @Override
    public void onDisable() {
        getLogger().info("only-one-sleeps disabled...");
        super.onDisable();
    }

    public void setConfigDefaults() {
        final FileConfiguration config = getConfig();
        config.addDefault("sleepDelay", 4);
        config.addDefault("change.weather.enabled", true);
        config.addDefault("change.time.enabled", true);
        config.addDefault("change.time.value", 0);
        config.addDefault("permissions.enabled", 0);
    }
}
