package nesb01t.monetdungeon.api;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class MapBlock {
    public static int getMapBlockX(LivingEntity entity) {
        int xCoordinate = entity.getLocation().getBlockX();
        int xBlock = (xCoordinate + 500) / 1000;
        return xBlock;
    }

    public static int getMapBlockZ(LivingEntity entity) {
        int zCoordinate = entity.getLocation().getBlockY();
        int zBlock = (zCoordinate + 500) / 1000;
        return zBlock;
    }

    public static void logMapBlock(Player player) {
        int BlockX = MapBlock.getMapBlockX(player);
        int BlockZ = MapBlock.getMapBlockZ(player);
        String mapBlockStr = "地图区块: " + String.valueOf(BlockX) + ", " + String.valueOf(BlockZ);
        player.sendMessage(mapBlockStr);
    }
}
