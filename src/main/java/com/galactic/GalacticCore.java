package com.galactic;

import com.galactic.commands.LockCommand;
import com.galactic.commands.MemCommand;
import com.galactic.events.ChatManager;
import com.galactic.events.DeathListener;
import com.galactic.events.JoinListener;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;
import java.util.UUID;

public class GalacticCore extends JavaPlugin
{
    private OfflinePlayer OWNER;

    public Optional<Player> getOwner()
    {
        return Optional.ofNullable(OWNER.getPlayer());
    }

    @Override
    public void onLoad()
    {
    }

    private <T extends Listener> T registerEvent(T listener)
    {
        getServer().getPluginManager().registerEvents(listener, this);
        return listener;
    }

    private void registerCommands()
    {
        LifecycleEventManager<Plugin> manager = this.getLifecycleManager();

        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();

            commands.register("lock", registerEvent(new LockCommand()));
            commands.register("mem", new MemCommand());
        });
    }


    private void registerEvents()
    {
        PluginManager manager = getServer().getPluginManager();

        manager.registerEvents(new ChatManager(this), this);
        manager.registerEvents(new DeathListener(), this);
        manager.registerEvents(new JoinListener(this), this);
    }

    @Override
    public void onEnable()
    {
        OWNER = Bukkit.getOfflinePlayer(UUID.fromString("97a2ce01-4159-498a-a242-06604a766019"));

        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable()
    {

    }
}
