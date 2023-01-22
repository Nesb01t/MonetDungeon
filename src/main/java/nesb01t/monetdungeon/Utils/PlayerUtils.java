package nesb01t.monetdungeon.Utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class PlayerUtils {
    public static Block getBlockUnderPlayer(Player player) {
        Location playerLoc = player.getLocation();
        playerLoc.setY(playerLoc.getY() - 0.01D);
        Block block = playerLoc.getWorld().getBlockAt(playerLoc);
        return block;
    }

    public static boolean isOnObsidian(Player player) {
        Location playerLoc = player.getLocation();
        playerLoc.setY(playerLoc.getY() - 0.01D);
        Block block = playerLoc.getWorld().getBlockAt(playerLoc);
        player.sendMessage(block.getType().toString());
        return block.getType() == Material.OBSIDIAN;
    }
}
