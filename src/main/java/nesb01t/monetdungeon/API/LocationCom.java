package nesb01t.monetdungeon.API;

import nesb01t.monetdungeon.MonetDungeon;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

import static nesb01t.monetdungeon.Utils.YamlUtils.saveYamlToFile;
import static nesb01t.monetdungeon.Utils.YamlUtils.useYamlFile;

public class LocationCom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) { // 禁止控制台
            MonetDungeon.plugin.getLogger().info("Error! wrong command used in console.");
            return true;
        }

        if (args.length == 0) { // 参数长度 = 0
            MonetDungeon.plugin.getLogger().info("Error! you did not provide any arguments.");
            return true;
        }

        switch (args[0]) {
            case "save":
                /**
                 * 参数依次为:
                 *  - 区块 0~N
                 *  - 层级 1~3
                 */
                if (args.length == 2) {
                    try {
                        saveLocationToFile(((Player) sender).getPlayer(), args[1], args[2]);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
        }
        return false;
    }

    /**
     * @param player 所在位置
     * @param blockX 所在地图区块
     * @param level  层级
     */
    private void saveLocationToFile(Player player, String blockX, String level) throws IOException {
        YamlConfiguration yaml = useYamlFile(blockX);

        ConfigurationSection list = yaml.getConfigurationSection(level);
        list.set(String.valueOf(list.getKeys(false).size()), player.getLocation());

        saveYamlToFile(blockX, yaml);
    }
}
