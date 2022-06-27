package ru.primer.mc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static ru.primer.mc.Main.bossBar;
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
        if(!vanish.contains(uuid)) {
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if (!player.hasPermission("vanish.vision")) {
                    player.hidePlayer(p);
                }
            }

            addPlayer(uuid);

            bossBar.addPlayer(p);

            message(getString("vanish-on"), p);
            return true;
        }

        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.showPlayer(p);
        }

        removePlayer(uuid);
        bossBar.removePlayer(p);

        message(getString("vanish-off"), p);
        return true;
    }
}
