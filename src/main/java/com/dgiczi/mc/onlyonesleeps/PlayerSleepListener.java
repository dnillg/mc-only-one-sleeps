package com.dgiczi.mc.onlyonesleeps;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import java.util.logging.Logger;

public class PlayerSleepListener implements Listener {

    private static final int TICKS_PER_SECOND = 20;
    private static final int MAX_SKEW_TICKS = 5;

    private final OnlyOneSleeps plugin;
    private final Logger logger;

    public PlayerSleepListener(OnlyOneSleeps plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        final Player player = event.getPlayer();
        if (plugin.getConfig().getBoolean("permissions.enabled")
                && !player.hasPermission("only-one-sleeps.use")) {
            return;
        }
        final long sleepDelay = plugin.getConfig().getLong("sleepDelay") * TICKS_PER_SECOND;
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            if (player.isSleeping() && player.getSleepTicks() >= sleepDelay - MAX_SKEW_TICKS) {
                final String infoMessage = String.format("%s has slept.", player.getName());
                logger.info(infoMessage);
                final World world = player.getWorld();
                if (plugin.getConfig().getBoolean("change.time.enabled")) {
                    world.setTime(plugin.getConfig().getLong("change.time.value"));
                }
                if (plugin.getConfig().getBoolean("change.weather.enabled")) {
                    world.setStorm(false);
                }
            }
        }, sleepDelay);
    }

}
