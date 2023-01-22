package nesb01t.monetdungeon.API;

import nesb01t.monetdungeon.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;

import static nesb01t.monetdungeon.MonetDungeon.plugin;

public class DungeonPanel {
    public static List<Player> cooldownPlayerList = new ArrayList<>();

    public static void openDungeonPanel(Player player) {
        openPanelInv(player);
        DungeonPanel.cooldownPlayerList.add(player);
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            DungeonPanel.cooldownPlayerList.remove(player);
        }, 40L);
    }

    public static class PanelListener implements Listener {
        @EventHandler
        public void moveOnPortal(PlayerMoveEvent event) {
            Player player = event.getPlayer();
            if (PlayerUtils.isOnObsidian(player) && !isCooldown(player)) {
                DungeonPanel.openDungeonPanel(player);
            }
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
