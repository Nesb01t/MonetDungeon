package nesb01t.monetdungeon.api;

import nesb01t.monetdungeon.utils.MathUtils;
import nesb01t.monetdungeon.utils.YamlUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.IOException;

import static nesb01t.monetdungeon.utils.YamlUtils.useYamlFile;

public class DungeonManager {
    public static void openDungeonManager(Player player, String blockX) throws IOException {
        // 打开地牢面板
        Inventory panelInv = getManagerInv(player, blockX);
        player.openInventory(panelInv);
    }

    private static Inventory getManagerInv(Player player, String blockX) throws IOException {
        // 创建 Inv
        Inventory panelInv = Bukkit.createInventory(player, 54);
        YamlConfiguration yaml = YamlUtils.useYamlFile(String.valueOf(blockX));
        int size_1 = YamlUtils.getListSize(blockX, "1");
        player.sendMessage(String.valueOf(size_1));

        return panelInv;
    }

    /**
     * 获取坐标
     *
     * @param blockX 所在地图区块
     * @param level  层级
     */
    public static Location getLocation(String blockX, String level) throws IOException {
        YamlConfiguration yaml = useYamlFile(String.valueOf(blockX)); // 读取 blockX -> 1.yml
        String rand = String.valueOf(MathUtils.getRandomBetween(0, YamlUtils.getListSize(blockX, level) - 1));
        Location loc = (Location) yaml.getConfigurationSection("level" + level).get(rand);
        return loc;
    }
}
