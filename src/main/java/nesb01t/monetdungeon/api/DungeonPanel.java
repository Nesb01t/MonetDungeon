package nesb01t.monetdungeon.api;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.IOException;

import static nesb01t.monetdungeon.MonetDungeon.plugin;

public class DungeonPanel {

    public static void openDungeonPanel(Player player) throws IOException {
        // 打开地牢面板
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            openPanelInv(player);
        }, 2L);
    }

    private static void openPanelInv(Player player) {
        // 创建 Inv
        Inventory panelInv = Bukkit.createInventory(player, 27);
        player.openInventory(panelInv);
    }
}
