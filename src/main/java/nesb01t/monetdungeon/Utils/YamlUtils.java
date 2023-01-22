package nesb01t.monetdungeon.Utils;

import nesb01t.monetdungeon.MonetDungeon;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class YamlUtils {
    public static YamlConfiguration useYamlFile(String fileName) throws IOException {
        File dataFolder = MonetDungeon.plugin.getDataFolder();
        File yamlFile = new File(dataFolder, fileName + ".yml");
        if (!yamlFile.exists()) {
            yamlFile.createNewFile();
        }
        return YamlConfiguration.loadConfiguration(yamlFile);
    }
}
