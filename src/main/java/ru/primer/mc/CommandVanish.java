package ru.primer.mc;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static ru.primer.mc.Main.bar;
import static ru.primer.mc.Utils.HashMapManager.addPlayer;
import static ru.primer.mc.Utils.HashMapManager.vanish;
import static ru.primer.mc.Utils.Utils.*;

public class CommandVanish implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(!(s instanceof Player)){
            messageNotPlayer();
            return true;
        }

        Player p = (Player) s;

        if(!p.hasPermission("vanish.use")){
            message(getString("no-permission"), p);
            return true;
        }

        UUID uuid = p.getUniqueId();
        if(!vanish.containsKey(uuid) || !vanish.get(uuid)) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (!player.hasPermission("vanish.vision")) {
                    player.hidePlayer(p);
                }
            }

            addPlayer(uuid, true);

            bar.setTitle(getString("vanish"));
            bar.setColor(BarColor.GREEN);
            bar.addPlayer(p);

            message(getString("vanish-on"), p);
            return true;
        }

        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.showPlayer(p);
        }

        addPlayer(uuid, false);
        bar.removePlayer(p);

        message(getString("vanish-off"), p);
        return true;
    }
}
