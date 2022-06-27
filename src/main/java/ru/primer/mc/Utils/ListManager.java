package ru.primer.mc.Utils;

import java.util.*;

public class ListManager {
    public static List<UUID> vanish = new ArrayList<>(Collections.emptyList());

    public static void addPlayer(UUID uuid) {
        vanish.add(uuid);
    }
    public static void removePlayer(UUID uuid) {
        vanish.remove(uuid);
    }
}
