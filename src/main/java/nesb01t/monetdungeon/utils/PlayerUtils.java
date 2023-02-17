package nesb01t.monetdungeon.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;

public class PlayerUtils {
    // 获取玩家脚下方块
    public static Block getBlockUnderPlayer(Player player) {
        Location loc = player.getLocation();
        loc.setY(loc.getY() - 0.01D);
        Block block = loc.getWorld().getBlockAt(loc);
        return block;
    }

    // 判断玩家站在黑曜石上
    public static boolean isOnObsidian(Player player) {
        return getBlockUnderPlayer(player).getType() == Material.OBSIDIAN;
    }

    // 判断玩家站在闪长岩上
    public static boolean isOnDiorite(Player player) {
        return getBlockUnderPlayer(player).getType() == Material.POLISHED_DIORITE;
    }

    // 判断玩家站在岩浆块上
    public static boolean isOnMagma(Player player) {
        return getBlockUnderPlayer(player).getType() == Material.MAGMA_BLOCK;
    }

    // 判断玩家正在浏览GUI
    public static boolean isViewingGUI(Player player) {
        return player.getOpenInventory().getType() == InventoryType.CHEST;
    }
}
