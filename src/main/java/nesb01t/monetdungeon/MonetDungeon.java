package nesb01t.monetdungeon;

import nesb01t.monetdungeon.API.DungeonPanel;
import nesb01t.monetdungeon.API.PortalListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class MonetDungeon extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new PortalListener(), plugin);
    }

    @Override
    public void onDisable() {
        plugin.getLogger().info("Dungeon service shutdown...");
    }
}
