package ru.primer.mc;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.plugin.java.JavaPlugin;
import ru.primer.mc.Events.JoinEvent;

import static ru.primer.mc.Utils.Utils.getString;

public final class Main extends JavaPlugin {

    public static Main instance;

    public static BossBar bossBar;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        BossBar bossBar = Bukkit.getServer().createBossBar(getString("vanish"), BarColor.GREEN, BarStyle.SOLID);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        getCommand("vanish").setExecutor(new CommandVanish());

    }

    @Override
    public void onDisable() {
    }

}
