package nesb01t.monetdungeon;

import nesb01t.monetdungeon.API.DungeonPanel;
import nesb01t.monetdungeon.API.MapBlock;
import nesb01t.monetdungeon.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.util.Vector;

import static nesb01t.monetdungeon.Utils.PlayerUtils.isOnObsidian;

public final class MonetDungeon extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new DungeonListener(), this);
        plugin = this;
    }

    @Override
    public void onDisable() {
        plugin.getLogger().info("Dungeon service shutdown...");
    }

    public class DungeonListener implements Listener {
        @EventHandler
        public void moveOnPortal(PlayerMoveEvent event) {
            Player player = event.getPlayer();

            if (isOnObsidian(player)) {
                DungeonPanel.openDungeonPanel(player);
            }
        }

        @EventHandler
        public void closePanel(InventoryCloseEvent event) {
            Player player = (Player) event.getPlayer();

            if (isOnObsidian(player)) {
                player.setVelocity(new Vector(3, 1, 0));
            }
        }
    }
}
