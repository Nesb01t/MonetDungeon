package nesb01t.monetdungeon.API;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.List;

import static nesb01t.monetdungeon.MonetDungeon.plugin;

public class DungeonPanel {
    public static List<Player> cooldownPlayerList;

    public static void openDungeonPanel(Player player) {
        if (!isCooldown(player)) {
            DungeonPanel.cooldownPlayerList.add(player);
            BukkitScheduler scheduler = Bukkit.getScheduler();
            scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
                @Override
                public void run() {
                    DungeonPanel.cooldownPlayerList.remove(player);
                }
            }, 10L);

            openPanelInv(player);
        }
    }

    private static void openPanelInv(Player player) {
        Inventory panelInv = Bukkit.createInventory(player, 27);
        player.openInventory(panelInv);
    }

    private static boolean isCooldown(Player player) {
        return cooldownPlayerList.contains(player);
    }
}
