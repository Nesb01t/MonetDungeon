package nesb01t.monetdungeon.Utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class PlayerUtils {
    public static Block getBlockUnderPlayer(Player player) {
        Location loc = player.getLocation();
        loc.setY(loc.getY() - 0.01D);
        Block block = loc.getWorld().getBlockAt(loc);
        return block;
    }

    public static boolean isOnObsidian(Player player) {
        return getBlockUnderPlayer(player).getType() == Material.OBSIDIAN;
    }

    public static boolean isViewingGUI(Player player) {
        return player.getOpenInventory().getType() == InventoryType.CHEST;
    }
}
