package server.Galactica.eventListenersTest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class EventListenersTest extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("The plugin is enabled");

        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player joinedPlayer = event.getPlayer();
        String targetPlayerName = "Big_Dragons";
        Player targetPlayer = Bukkit.getPlayer(targetPlayerName);

        if (targetPlayer != null && targetPlayer.isOnline()) {
            // Send the message to the target player
            targetPlayer.sendMessage(ChatColor.BLUE + joinedPlayer.getName() + ChatColor.GOLD + " has joined " + ChatColor.AQUA + "GALATICASMP");
            targetPlayer.playSound(targetPlayer.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 10.0f, 1.0f);
        } else {
            //Target player is not online
            System.out.println("Target player " + targetPlayerName + " is not online.");
        }
    }

    @EventHandler
    public void onBedEnter(PlayerBedEnterEvent event) {
        Player enteringPlayer = event.getPlayer();
        String playerName = enteringPlayer.getName();

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player != enteringPlayer) {
                if (!player.isSleeping()) {
                    player.sendMessage("Get in bed " + playerName + "!!");
                }
            }
        }
    }
}