package nesb01t.monetdungeon.utils;

import nesb01t.monetdungeon.MonetDungeon;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlUtils {
    // 通过文件名获取 YAML
    public static YamlConfiguration useYamlFile(String fileName) throws IOException {
        File folder = MonetDungeon.plugin.getDataFolder();
        if (!folder.isDirectory()) {
            folder.mkdir();
        }

        File file = new File(folder, fileName + ".yml");
        if (!file.exists()) {
            file.createNewFile();
        }

        return YamlConfiguration.loadConfiguration(file);
    }

    // 通过 YAML 保存到文件名
    public static void saveYamlToFile(String fileName, YamlConfiguration yaml) throws IOException {
        File folder = MonetDungeon.plugin.getDataFolder();
        if (!folder.isDirectory()) {
            folder.mkdir();
        }

        File file = new File(folder, fileName + ".yml");
        if (!file.exists()) {
            file.createNewFile();
        }

        yaml.save(file);
    }

    public static int getListSize(String blockX, String level) throws IOException {
        YamlConfiguration yaml = useYamlFile(blockX);
        ConfigurationSection list = yaml.getConfigurationSection("level" + level);
        return list.getKeys(false).size();
    }
}
