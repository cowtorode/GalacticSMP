package com.galactic.commands;

import com.galactic.globals.Messages;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class LockCommand implements BasicCommand, Listener
{
    private boolean locked;

    @EventHandler(priority = EventPriority.LOWEST) // runs first
    public void onPreLogin(PlayerLoginEvent event)
    {
        if (locked && !event.getPlayer().hasPermission("galactic.command.lock"))
        {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, Messages.LOCKED_SERVER);
        }
    }

    @Override
    public String permission()
    {
        return "galactic.command.lock";
    }

    @Override
    public void execute(CommandSourceStack stack, String[] args)
    {
        // lock the server so that players (without permission) can't join
        locked = !locked;
        stack.getSender().sendMessage(locked ? Messages.SERVER_LOCKED : Messages.SERVER_UNLOCKED);
    }
}
