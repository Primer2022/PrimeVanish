package ru.primer.mc.Utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ru.primer.mc.Main;

public class Utils {

    public static FileConfiguration cfg = Main.instance.getConfig();

    public static void message(String message, Player p) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void messageNotPlayer() {
        System.out.println(ChatColor.translateAlternateColorCodes('&', getString("not-player")));
    }

    public static String getString(String path) {
        cfg.getString(path);
        return cfg.getString(path);
    }

}
