package nesb01t.monetdungeon;

import nesb01t.monetdungeon.com.LocationCom;
import nesb01t.monetdungeon.com.ManagerCom;
import nesb01t.monetdungeon.listener.ManagerListener;
import nesb01t.monetdungeon.listener.PanelListener;
import nesb01t.monetdungeon.listener.PortalListener;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class MonetDungeon extends JavaPlugin {
    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        // 注册事件
        plugin = this;
        easyRegEvent(new PortalListener());
        easyRegEvent(new ManagerListener());
        easyRegEvent(new PanelListener());
        easyRegCom(new LocationCom(), "loc");
        easyRegCom(new ManagerCom(), "dun");
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
