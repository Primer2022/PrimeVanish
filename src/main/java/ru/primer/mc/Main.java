package ru.primer.mc;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.plugin.java.JavaPlugin;
import ru.primer.mc.Events.JoinEvent;
import java.io.File;

public final class Main extends JavaPlugin {

    public static Main instance;

    public static BossBar bar = Bukkit.getServer().createBossBar("", BarColor.GREEN, BarStyle.SOLID);

    @Override
    public void onEnable() {
        File file = new File("plugins/PrimeVanish");
        boolean flag = file.mkdir();
        saveDefaultConfig();
        instance = this;
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        getCommand("vanish").setExecutor(new CommandVanish());

    }

    @Override
    public void onDisable() {
    }

}
