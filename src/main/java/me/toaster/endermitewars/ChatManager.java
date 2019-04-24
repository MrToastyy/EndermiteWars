package me.toaster.endermitewars;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class ChatManager {
    EndermiteWars main;

    public ChatManager(EndermiteWars main) {
        this.main = main;
    }

    public void sendConsoleMessage(String message) {
        // This will log a formatted message to the console.
        main.getServer().getConsoleSender().sendMessage("§7[§bEndermiteWars§7] §r" + message);
    }

    public void specialBroadcastMessage(String message) {
        for (Player player : main.getServer().getOnlinePlayers()) {
            player.sendMessage("§9EndermiteWars§7-§bBroadcast §8» §r" + message);
        }
    }

    public void broadcastMessage(String message) {
        // This will send a message to all the players that are currently online.
        for (Player player : main.getServer().getOnlinePlayers()) {
            sendMessage(message, player);
        }
    }

    public void sendMessage(String message, Player player) {
        player.sendMessage("§9EndermiteWars §8» §r" + message);
    }

    public void actionBarMessage(String message, Player player) {
        player.sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }
}
