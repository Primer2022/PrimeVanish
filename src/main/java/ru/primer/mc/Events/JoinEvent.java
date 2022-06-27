package ru.primer.mc.Events;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Set;
import java.util.UUID;

import static ru.primer.mc.Main.bar;
import static ru.primer.mc.Utils.ListManager.vanish;
import static ru.primer.mc.Utils.Utils.getString;

public class JoinEvent implements Listener {
    @EventHandler
    public void vanishPlayer(PlayerJoinEvent e) {
        if (vanish.isEmpty()) {
            return;
        }

        Player p = e.getPlayer();

        for (int i = 0; vanish.size() > i; i++) {
            UUID uuid = vanish.get(i);
            Player player = Bukkit.getPlayer(vanish.get(i));

            if (!vanish.contains(uuid)) {
                return;
            }

            if (player == p) {
                for (Player players : Bukkit.getServer().getOnlinePlayers()) {
                    players.hidePlayer(player);
                }
                bar.setTitle(getString("vanish"));
                bar.setColor(BarColor.GREEN);
                bar.addPlayer(player);
                return;
            }

            if (p.hasPermission("vanish.vision")) {
                return;
            }

            p.hidePlayer(player);
            return;
        }
    }
}
