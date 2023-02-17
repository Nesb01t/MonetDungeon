package nesb01t.monetdungeon.listener;

import nesb01t.monetdungeon.api.MapBlock;
import nesb01t.monetdungeon.utils.PlayerUtils;
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
import static nesb01t.monetdungeon.api.PortalSystem.*;

public class PortalListener implements Listener {

    private static List<Player> cooldownPlayerList = new ArrayList<>();

    @EventHandler
    public void moveOnPortal(PlayerMoveEvent event) throws IOException {
        Player player = event.getPlayer();
        // 冷却中
        if (isCooldown(player)) {
            return;
        }


        if (PlayerUtils.isOnObsidian(player)) {
            // 黑曜石 level 1
            useObsidianPortal(player, MapBlock.getMapBlockX(player));

        } else if (PlayerUtils.isOnDiorite(player)) {
            // 闪长岩 level 2
            useDioritePortal(player, MapBlock.getMapBlockX(player));

        } else if (PlayerUtils.isOnMagma(player)) {
            // 岩浆石 level 3
            useMagmaPortal(player, MapBlock.getMapBlockX(player));

        }

        setCooldown(player, 0.1);
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
