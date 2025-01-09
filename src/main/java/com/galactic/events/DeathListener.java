package com.galactic.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener
{
    @EventHandler
    public void onDeath(PlayerDeathEvent event)
    {
        Player player = event.getEntity();
        Location loc = player.getLocation();

        player.sendMessage("You died at (" + loc.getX() + ", " + loc.getY() + ", " + loc.getZ() + ")");
    }
}
