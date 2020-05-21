package com.dgiczi.mc.furnaceplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

import java.util.logging.Logger;

public class PlayerSleepListener implements Listener
{

    private final SoloSleep plugin;
    private final Logger logger;

    public PlayerSleepListener(SoloSleep plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event)
    {
        final Player player = event.getPlayer();
        logger.info(String.format("%s is sleeping...", player.getName()));
        plugin.getServer().broadcastMessage(String.format("%s is sleeping...", player.getName()));
        plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, () -> {
            if (player.isSleeping()) {
                player.getWorld().setTime(0);
            }
        }, 20);
    }

}
