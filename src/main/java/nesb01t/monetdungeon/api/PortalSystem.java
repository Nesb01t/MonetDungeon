package nesb01t.monetdungeon.api;

import org.bukkit.entity.Player;

import java.io.IOException;

public class PortalSystem {
    public static void useObsidianPortal(Player player, int blockX) throws IOException { // level 1
        int OBSIDIAN = 1;
        String level = String.valueOf(OBSIDIAN);
        String block = String.valueOf(blockX);
        if (blockX == 1) {
            // 主城面板
            player.sendMessage("进入传送门...");
            DungeonPanel.openDungeonPanel(player);
            player.teleport(LocFileParser.getLocation(block, level));
        } else if (blockX <= 10) {
            // 副本 (一层奖励)
            player.sendMessage("魔法将你传送到了另一个区域...");
            player.teleport(LocFileParser.getLocation(block, level));
        }
    }

    public static void useDioritePortal(Player player, int blockX) throws IOException { // level 2
        int DIORITE = 2;
        String level = String.valueOf(DIORITE);
        String block = String.valueOf(blockX);
        if (blockX <= 10) {
            // 副本 (二层奖励)
            player.sendMessage("你感到这里充满了危险...");
            player.teleport(LocFileParser.getLocation(block, level));
        }
    }

    public static void useMagmaPortal(Player player, int blockX) throws IOException { // level 3
        int MAGMA_BLOCK = 3;
        String level = String.valueOf(MAGMA_BLOCK);
        String block = String.valueOf(blockX);
        if (blockX == 1) {
            // 主城面板
            player.sendMessage("回到小屋...");
            player.teleport(LocFileParser.getLocation(block, level));
        } else if (blockX <= 10) {
            // 副本 (最终 & 三层奖励)
            player.sendMessage("打开返程传送门...");
            player.teleport(LocFileParser.getLocation(block, level));
        }
    }
}
