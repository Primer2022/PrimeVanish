package ru.primer.mc.Utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import ru.primer.mc.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Utils {

    public static List<UUID> vanish = new ArrayList<>(Collections.emptyList());

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

    public static void addPlayer(UUID uuid) {
        vanish.add(uuid);
    }

    public static void removePlayer(UUID uuid) {
        vanish.remove(uuid);
    }

}
