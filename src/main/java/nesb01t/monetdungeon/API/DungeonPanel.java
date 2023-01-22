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

    public static void openDungeonPanel(Player player) {
        // 打开地牢面板
        openPanelInv(player);
        PortalListener.setCooldown(player, 2);
    }

    private static void openPanelInv(Player player) {
        Inventory panelInv = Bukkit.createInventory(player, 27);
        player.openInventory(panelInv);
    }
}
