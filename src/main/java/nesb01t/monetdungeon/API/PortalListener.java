package nesb01t.monetdungeon.API;

import nesb01t.monetdungeon.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.List;

import static nesb01t.monetdungeon.MonetDungeon.plugin;

public class PortalListener implements Listener {

    private static List<Player> cooldownPlayerList = new ArrayList<>();

    @EventHandler
    public void moveOnPortal(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        // 黑曜石上 & 不在冷却
        if (PlayerUtils.isOnObsidian(player) && !isCooldown(player)) {
            DungeonPanel.openDungeonPanel(player);
        }
    }


    public static void setCooldown(Player player, long seconds) {
        cooldownPlayerList.add(player);
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            cooldownPlayerList.remove(player);
        }, seconds * 20L);
    }

    private static boolean isCooldown(Player player) {
        return cooldownPlayerList.contains(player);
    }


}
