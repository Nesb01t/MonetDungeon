package nesb01t.monetdungeon.api;

import nesb01t.monetdungeon.utils.MathUtils;
import nesb01t.monetdungeon.utils.YamlUtils;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

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
    public static Location getLocation(String blockX, String level, String index) throws IOException {
        YamlConfiguration yaml = useYamlFile(String.valueOf(blockX)); // 读取 blockX -> 1.yml
        Location loc = (Location) yaml.getConfigurationSection("level" + level).get(index);
        return loc;
    }

    /**
     * 获取随机坐标
     *
     * @param blockX 所在地图区块
     * @param level  层级
     */
    public static Location getRandomLocation(String blockX, String level) throws IOException {
        YamlConfiguration yaml = useYamlFile(String.valueOf(blockX)); // 读取 blockX -> 1.yml
        String rand = String.valueOf(MathUtils.getRandomBetween(0, YamlUtils.getListSize(blockX, level) - 1));
        Location loc = (Location) yaml.getConfigurationSection("level" + level).get(rand);
        return loc;
    }

    /**
     * 保存坐标
     *
     * @param location 位置
     * @param blockX   所在地图区块
     * @param level    层级
     */
    public static void saveLocation(Location location, String blockX, String level) throws IOException {
        YamlConfiguration yaml = useYamlFile(blockX);
        ConfigurationSection list;

        if (yaml.isConfigurationSection("level" + level)) {
            // 存在列表 -> 读
            list = yaml.getConfigurationSection("level" + level);
        } else {
            // 不存在列表 -> 创建
            list = yaml.createSection("level" + level);
        }

        list.set(String.valueOf(list.getKeys(false).size()), location);
        saveYamlToFile(blockX, yaml);
    }
}
