package com.galactic.events;

import com.galactic.GalacticCore;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener
{
    private final GalacticCore plugin;

    public JoinListener(GalacticCore plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        plugin.getOwner().ifPresent(owner -> {
            owner.playSound(owner, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
        });
    }
}
