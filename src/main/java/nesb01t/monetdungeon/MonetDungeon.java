package nesb01t.monetdungeon;

import nesb01t.monetdungeon.API.LocationCom;
import nesb01t.monetdungeon.API.PortalListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MonetDungeon extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        easyRegEvent(new PortalListener());
        easyRegCom(new LocationCom(), "modun");
    }

    @Override
    public void onDisable() {
        plugin.getLogger().info("Dungeon service shutdown...");
    }

    private void easyRegEvent(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
    }

    private void easyRegCom(CommandExecutor executor, String commandName) {
        getCommand(commandName).setExecutor(executor);
    }
}
