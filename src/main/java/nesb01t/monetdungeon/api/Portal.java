package nesb01t.monetdungeon.api;

import nesb01t.monetdungeon.com.LocationCom;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Portal {
    public static void useObsidianPortal(Player player, int blockX) throws IOException { // level 1
        String level = String.valueOf(1);
        if (blockX == 1) { // 主城
            DungeonPanel.openDungeonPanel(player);
            LocationCom.teleportToFileLoc(player, String.valueOf(blockX), level);
        } else if (blockX <= 10) { // 副本
            LocationCom.teleportToFileLoc(player, String.valueOf(blockX), level);
        }
    }
}
