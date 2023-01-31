package nesb01t.monetdungeon.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.IOException;

public class DungeonManager {
    public static void openDungeonManager(Player player) throws IOException {
        // 打开地牢面板
        Inventory panelInv = getManagerInv(player);
        player.openInventory(panelInv);
    }

    private static Inventory getManagerInv(Player player) {
        // 创建 Inv
        Inventory panelInv = Bukkit.createInventory(player, 27);

        return panelInv;
    }
}
