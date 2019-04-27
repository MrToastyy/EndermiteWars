package me.toaster.bedwars;

import org.bukkit.plugin.java.JavaPlugin;

public class BedWars extends JavaPlugin {

    public ChatManager cm;
    public ScoreboardManager sm;

    @Override
    public void onEnable() {
        //Create instances
        cm = new ChatManager(this);
        sm = new ScoreboardManager(this);

        onStart();
    }

    private void onStart() {
        //Runs when every other startup task is finished.
        cm.sendConsoleMessage("§aHas been enabled.");
        sm.onEnable();
    }

    @Override
    public void onDisable() {
        //Plugin shutdown logic
        cm.sendConsoleMessage("§aHas been disabled.");
    }
}
