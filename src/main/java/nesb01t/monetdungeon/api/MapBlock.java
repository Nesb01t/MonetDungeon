package nesb01t.monetdungeon.api;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class MapBlock {
    // 获取 X 轴坐标，代表副本区域
    // 1000 -> 主城
    // 2000 -> 永歌森林
    // 3000 -> 遗迹矿山
    public static int getMapBlockX(LivingEntity entity) {
        int xCoordinate = entity.getLocation().getBlockX();
        int xBlock = (xCoordinate + 500) / 1000;
        return xBlock;
    }

    // 获取 Z 轴坐标，用作复制副本编号
    public static int getMapBlockZ(LivingEntity entity) {
        int zCoordinate = entity.getLocation().getBlockY();
        int zBlock = (zCoordinate + 500) / 1000;
        return zBlock;
    }

    // 输出玩家当前所在地图区块
    public static void logMapBlock(Player player) {
        int BlockX = MapBlock.getMapBlockX(player);
        int BlockZ = MapBlock.getMapBlockZ(player);
        String mapBlockStr = "地图区块: " + String.valueOf(BlockX) + ", " + String.valueOf(BlockZ);
        player.sendMessage(mapBlockStr);
    }
}
