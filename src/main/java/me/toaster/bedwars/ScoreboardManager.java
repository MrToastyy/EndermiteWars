package me.toaster.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

public class ScoreboardManager {

    BedWars main;

    public ScoreboardManager(BedWars main) {
        this.main = main;
    }

    public void onEnable() {
        enableScoreboardUpdater();
    }

    private void enableScoreboardUpdater() {
        org.bukkit.scoreboard.ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("BedWarsLobby","dummy", "§f§lXenos");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Team rank = scoreboard.registerNewTeam("rank");                         rank.addEntry("§9§l> §b§lRank:");               objective.getScore("§9§l> §b§lRank:").setScore(13);
        Team rankValue = scoreboard.registerNewTeam("rankValue");               rankValue.addEntry("§r");                       objective.getScore("§r").setScore(12);

        Team blank1 = scoreboard.registerNewTeam("blank1");                     blank1.addEntry(" ");                           objective.getScore(" ").setScore(11);

        Team coins = scoreboard.registerNewTeam("coins");                       coins.addEntry("§9§l> §b§lCoins:");             objective.getScore("§9§l> §b§lCoins:").setScore(10);
        Team coinsValue = scoreboard.registerNewTeam("coinsValue");             coinsValue.addEntry("§r§r");                    objective.getScore("§r§r").setScore(9);

        Team blank2 = scoreboard.registerNewTeam("blank2");                     blank2.addEntry("  ");                          objective.getScore("  ").setScore(8);

        Team level = scoreboard.registerNewTeam("level");                       level.addEntry("§9§l> §b§lLevel:");             objective.getScore("§9§l> §b§lLevel:").setScore(7);
        Team levelValue = scoreboard.registerNewTeam("levelValue");             levelValue.addEntry("§r§r§r");                  objective.getScore("§r§r§r").setScore(6);

        Team blank3 = scoreboard.registerNewTeam("blank3");                     blank3.addEntry("   ");                         objective.getScore("   ").setScore(5);

        Team bedBreaks = scoreboard.registerNewTeam("bedBreaks");               bedBreaks.addEntry("§9§l> §b§lBed Breaks:");    objective.getScore("§9§l> §b§lBed Breaks:").setScore(4);
        Team bedBreaksValue = scoreboard.registerNewTeam("bedBreaksValue");     bedBreaksValue.addEntry("§r§r§r§r");            objective.getScore("§r§r§r§r").setScore(3);

        Team blank4 = scoreboard.registerNewTeam("blank4");                     blank4.addEntry("    ");                        objective.getScore("    ").setScore(2);

        Team finalKills = scoreboard.registerNewTeam("finalKills");             finalKills.addEntry("§9§l> §b§lFinal Kills:");  objective.getScore("§9§l> §b§lFinal Kills:").setScore(1);
        Team finalKillsValue = scoreboard.registerNewTeam("finalKillsValue");   finalKillsValue.addEntry("§r§r§r§r§r");         objective.getScore("§r§r§r§r§r").setScore(0);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable() {
            int sec = 0;

            @Override
            public void run() {
                /*
                                switch (sec) {
                    case 0:
                    case 11:
                        objective.setDisplayName("§6§l<<<§f§l< §d§lXenos §f§l>§6§l>>>");
                        break;
                    case 1:
                    case 10:
                        objective.setDisplayName("§6§l<<§f§l<§6§l< §d§lXenos §6§l>§f§l>§6§l>>");
                        break;
                    case 2:
                    case 9:
                        objective.setDisplayName("§6§l<§f§l<§6§l<< §d§lXenos §6§l>>§f§l>§6§l>");
                        break;
                    case 3:
                    case 8:
                        objective.setDisplayName("§f§l<§6§l<<< §d§lXenos §6§l>>>§f§l>");
                        break;
                    case 4: case 5: case 6: case 7:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                        objective.setDisplayName("§6§l<<<< §d§lXenos §6§l>>>>");
                        break;
                }
                 */
                switch (sec) {
                    case 0:
                    case 14:
                        objective.setDisplayName("§d§lX§f§lenos");
                        break;
                    case 1:
                    case 13:
                        objective.setDisplayName("§5§lX§d§le§f§lnos");
                        break;
                    case 2:
                    case 12:
                        objective.setDisplayName("§d§lX§5§le§d§ln§f§los");
                        break;
                    case 3:
                    case 11:
                        objective.setDisplayName("§f§lX§d§le§5§ln§d§lo§f§ls");
                        break;
                    case 4:
                    case 10:
                        objective.setDisplayName("§f§lXe§d§ln§5§lo§d§ls");
                        break;
                    case 5:
                    case 9:
                        objective.setDisplayName("§f§lXen§d§lo§5§ls");
                        break;
                    case 6:
                    case 8:
                        objective.setDisplayName("§f§lXeno§d§ls");
                        break;
                    case 7:
                    case 15: case 16: case 17: case 18: case 19: case 20:
                        objective.setDisplayName("§f§lXenos");
                        break;
                }

                for(Player player : Bukkit.getOnlinePlayers()) {
                    rankValue.setSuffix("§r[rank]");
                    coinsValue.setSuffix("§r[coins]");
                    levelValue.setSuffix("§r[level]");
                    finalKillsValue.setSuffix("§r[finalKills]");
                    bedBreaksValue.setSuffix("§r[bedBreaks]");

                    player.setScoreboard(scoreboard);
                }

                if(sec == 20) {
                    sec = -1;
                }
                sec++;
            }
        }, 0, 1);
    }
}
