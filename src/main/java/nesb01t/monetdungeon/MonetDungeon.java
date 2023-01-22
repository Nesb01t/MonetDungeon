package nesb01t.monetdungeon;

import nesb01t.monetdungeon.API.MapBlock;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

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

            int BlockX = MapBlock.getMapBlockX(player);
            int BlockZ = MapBlock.getMapBlockZ(player);
            String mapBlock = "地图区块: " + String.valueOf(BlockX) + ", " + String.valueOf(BlockZ);

            Location playerLoc = player.getLocation();
            Block block = playerLoc.getWorld().getBlockAt(playerLoc);
            String blockName = block.getBlockData().getAsString(true);
            
            player.sendMessage(mapBlock + blockName);
        }
    }
}
