package com.prixix.ultraapi;

import org.bukkit.plugin.java.JavaPlugin;

public final class UltraAPI extends JavaPlugin {

    private static UltraAPI instance = null;

    public static UltraAPI getInstance() {
        return instance;
    }

    @Override
    public void onLoad() {
        instance = this;
    }
}
