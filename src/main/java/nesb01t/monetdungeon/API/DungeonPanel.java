package nesb01t.monetdungeon.API;

import nesb01t.monetdungeon.Utils.MathUtils;
import nesb01t.monetdungeon.Utils.PlayerUtils;
import nesb01t.monetdungeon.Utils.YamlUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static nesb01t.monetdungeon.MonetDungeon.plugin;
import static nesb01t.monetdungeon.Utils.YamlUtils.useYamlFile;

public class DungeonPanel {

    public static void openDungeonPanel(Player player) throws IOException {
        // 传送到旁边
        YamlConfiguration yaml = useYamlFile(String.valueOf(1));
        String rand = String.valueOf(MathUtils.getRandomBetween(0, YamlUtils.getListSize("1", "1") - 1));
        Location loc = (Location) yaml.getConfigurationSection(String.valueOf(1)).get(rand);
        player.teleport(loc);

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
