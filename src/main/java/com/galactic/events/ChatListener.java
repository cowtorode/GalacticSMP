package com.galactic.events;

import com.galactic.GalacticCore;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class ChatListener implements Listener
{
    private final GalacticCore plugin;

    public ChatListener(GalacticCore plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event)
    {
        event.setFormat("&7%1$s: &f%2$s");
    }
}
