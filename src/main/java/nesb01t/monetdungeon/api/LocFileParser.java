package nesb01t.monetdungeon.api;

import nesb01t.monetdungeon.utils.MathUtils;
import nesb01t.monetdungeon.utils.YamlUtils;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;

import static nesb01t.monetdungeon.utils.YamlUtils.saveYamlToFile;
import static nesb01t.monetdungeon.utils.YamlUtils.useYamlFile;

public class LocFileParser {
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

    /**
     * 传送坐标
     *
     * @param player 所在位置
     * @param blockX 所在地图区块
     * @param level  层级
     */
    public static void teleportToFileLoc(Player player, String blockX, String level) throws IOException {
        YamlConfiguration yaml = useYamlFile(String.valueOf(blockX));
        String rand = String.valueOf(MathUtils.getRandomBetween(0, YamlUtils.getListSize(blockX, level) - 1));
        Location loc = (Location) yaml.getConfigurationSection("level" + level).get(rand);
        player.teleport(loc);
    }

    /**
     * 保存坐标
     *
     * @param player 所在位置
     * @param blockX 所在地图区块
     * @param level  层级
     */
    public static void saveLocationToFile(Player player, String blockX, String level) throws IOException {
        YamlConfiguration yaml = useYamlFile(blockX);
        ConfigurationSection list;

        if (yaml.isConfigurationSection("level" + level)) {
            // 存在列表 -> 读
            list = yaml.getConfigurationSection("level" + level);
        } else {
            // 不存在列表 -> 创建
            list = yaml.createSection("level" + level);
        }

        list.set(String.valueOf(list.getKeys(false).size()), player.getLocation());

        player.sendMessage("尝试保存坐标...");
        saveYamlToFile(blockX, yaml);
    }
}
