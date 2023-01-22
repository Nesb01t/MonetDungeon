package nesb01t.monetdungeon;

import nesb01t.monetdungeon.API.DungeonPanel;
import nesb01t.monetdungeon.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class MonetDungeon extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(new DungeonListener(), plugin);
    }

    @Override
    public void onDisable() {
        plugin.getLogger().info("Dungeon service shutdown...");
    }

    public class DungeonListener implements Listener {

        @EventHandler
        public void moveOnPortal(PlayerMoveEvent event) {
            Player player = event.getPlayer();
            getLogger().info("move");
            if (PlayerUtils.isOnObsidian(player)) {
                DungeonPanel.openDungeonPanel(player);
            }
        }

        @EventHandler
        public void closePanel(InventoryCloseEvent event) {
            Player player = (Player) event.getPlayer();
            getLogger().info("close");
            if (PlayerUtils.isOnObsidian(player)) {
                player.setVelocity(new Vector(3, 1, 0));
            }
        }

    }
}
