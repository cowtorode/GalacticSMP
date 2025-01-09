package com.galactic;

import com.galactic.events.DeathListener;
import com.galactic.events.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
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

    private void registerEvents()
    {
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
    }

    @Override
    public void onEnable()
    {
        OWNER = Bukkit.getOfflinePlayer(UUID.fromString("97a2ce01-4159-498a-a242-06604a766019"));

        registerEvents();
    }

    @Override
    public void onDisable()
    {

    }
}
