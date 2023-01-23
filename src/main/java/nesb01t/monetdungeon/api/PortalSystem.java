package nesb01t.monetdungeon.api;

import nesb01t.monetdungeon.com.LocationCom;
import org.bukkit.entity.Player;

import java.io.IOException;

public class PortalSystem {
    public static void useObsidianPortal(Player player, int blockX) throws IOException { // level 1
        String level = String.valueOf(1);
        if (blockX == 1) {
            // 主城面板
            DungeonPanel.openDungeonPanel(player);
            LocationCom.teleportToFileLoc(player, String.valueOf(blockX), level);
        } else if (blockX <= 10) {
            // 副本 (一层奖励)
            LocationCom.teleportToFileLoc(player, String.valueOf(blockX), level);
        }
    }

    public static void useDioritePortal(Player player, int blockX) throws IOException { // level 2
        String level = String.valueOf(2);
        if (blockX <= 10) {
            // 副本 (二层奖励)
            LocationCom.teleportToFileLoc(player, String.valueOf(blockX), level);
        }
    }

    public static void useMagmaPortal(Player player, int blockX) throws IOException { // level 3
        String level = String.valueOf(3);
        if (blockX <= 10) {
            // 副本 (最终 & 三层奖励)
            LocationCom.teleportToFileLoc(player, String.valueOf(blockX), level);
        }
    }
}
