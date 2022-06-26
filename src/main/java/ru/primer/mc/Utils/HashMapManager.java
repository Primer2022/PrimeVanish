package ru.primer.mc.Utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HashMapManager {
    public static Map<UUID, Boolean> vanish = new HashMap<>(Collections.emptyMap());

    public static void addPlayer(UUID uuid, boolean value) {
        vanish.put(uuid, value);
    }
}
