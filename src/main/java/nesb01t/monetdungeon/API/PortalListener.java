package nesb01t.monetdungeon.API;

import nesb01t.monetdungeon.Utils.PlayerUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static nesb01t.monetdungeon.MonetDungeon.plugin;

public class PortalListener implements Listener {

    private static List<Player> cooldownPlayerList = new ArrayList<>();

    @EventHandler
    public void moveOnPortal(PlayerMoveEvent event) throws IOException {
        Player player = event.getPlayer();
        // 冷却中
        if (isCooldown(player)) {
            return;
        }

        // 黑曜石上
        if (PlayerUtils.isOnObsidian(player) && !isCooldown(player)) {
            DungeonPanel.openDungeonPanel(player);
        }

        PortalListener.setCooldown(player, 0.1);
    }


    public static void setCooldown(Player player, double seconds) {
        cooldownPlayerList.add(player);
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            cooldownPlayerList.remove(player);
        }, (long) (seconds * 20L));
    }

    private static boolean isCooldown(Player player) {
        return cooldownPlayerList.contains(player);
    }


}
