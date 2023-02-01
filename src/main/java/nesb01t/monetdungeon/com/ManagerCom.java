package nesb01t.monetdungeon.com;

import nesb01t.monetdungeon.MonetDungeon;
import nesb01t.monetdungeon.api.DungeonManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class ManagerCom implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) { // 禁止控制台
            MonetDungeon.plugin.getLogger().info("Error! wrong command used in console.");
            return true;
        }

        if (!sender.isOp()) { // 必须是OP
            sender.sendMessage("Error! you don't have permission.");
            return true;
        }

        try {
            DungeonManager.openDungeonManager((Player) sender);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
