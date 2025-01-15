package com.galactic.events;

import com.galactic.GalacticCore;
import com.galactic.chat.LanguageProcessor;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ChatManager implements Listener
{
    private final GalacticCore plugin;
    private final Random random = new Random();

    private final LanguageProcessor bettie = new LanguageProcessor();

    public ChatManager(GalacticCore plugin)
    {
        this.plugin = plugin;
    }

    private long nextLong(long min, long max)
    {
        return random.nextLong(max - min) + min;
    }

    private void scheduleBettieMessage(String message)
    {
        Bukkit.getAsyncScheduler().runDelayed(plugin, task ->
        {
            Bukkit.broadcastMessage("<Bettie> " + message);
        }, nextLong(1500, 3000), TimeUnit.MILLISECONDS);
    }

    @EventHandler
    public void onChat(AsyncChatEvent event)
    {
        Component message = event.message();

        if (!(message instanceof TextComponent))
        {
            event.getPlayer().sendMessage("message is not an instanceof TextComponent");
            return;
        }

        String content = ((TextComponent) message).content();
        String reply = bettie.stimulate(content);

        if (reply != null)
        {
            scheduleBettieMessage(reply);
        }
    }
}
