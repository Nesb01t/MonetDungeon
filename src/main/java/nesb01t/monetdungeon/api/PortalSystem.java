package nesb01t.monetdungeon.api;

import nesb01t.monetdungeon.utils.MsgUtils;
import org.bukkit.entity.Player;

import java.io.IOException;

public class PortalSystem {
    // 黑曜石门，放置在第一层，传送到第二层
    public static void useObsidianPortal(Player player, int blockX) throws IOException {
        int OBSIDIAN = 1;
        String level = String.valueOf(OBSIDIAN);
        String block = String.valueOf(blockX);
        if (blockX == 1) {
            // 主城的黑曜石门 -> 打开面板
            MsgUtils.Send(player, "&c系统提示", "进入传送门...");
            DungeonPanel.openDungeonPanel(player);
            player.teleport(LocFileParser.getRandomLocation(block, level));
        } else if (blockX <= 10) {
            // 副本 (第一层到第二层的奖励)
            MsgUtils.Send(player, "&c系统提示", "魔法将你传送到了下一层...");
            player.teleport(LocFileParser.getRandomLocation(block, level));
        }
    }

    // 闪长岩门，放置在第二层，传送到第三层
    public static void useDioritePortal(Player player, int blockX) throws IOException {
        int DIORITE = 2;
        String level = String.valueOf(DIORITE);
        String block = String.valueOf(blockX);
        if (blockX <= 10) {
            // 副本 (第二层到第三层的奖励)
            MsgUtils.Send(player, "&c系统提示", "进入最深处, 胁迫正在接近...");
            player.teleport(LocFileParser.getRandomLocation(block, level));
        }
    }

    // 岩浆块门，放置在第三层，给玩家奖励
    public static void useMagmaPortal(Player player, int blockX) throws IOException {
        int MAGMA_BLOCK = 3;
        String level = String.valueOf(MAGMA_BLOCK);
        String block = String.valueOf(blockX);
        if (blockX == 1) {
            // 主城的岩浆石门 -> 回到小屋
            MsgUtils.Send(player, "&c系统提示", "回到了小屋...");
            player.teleport(LocFileParser.getRandomLocation(block, level));
        } else if (blockX <= 10) {
            // 副本 (最终 & 第三层的奖励)
            MsgUtils.Send(player, "&c系统提示", "进入了返程传送门...");
            player.teleport(LocFileParser.getRandomLocation(block, level));
        }
    }
}
