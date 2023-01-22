package nesb01t.monetdungeon.API;

import nesb01t.monetdungeon.MonetDungeon;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

        // Debugger
        sender.sendMessage(label);
        for (String str : args) {
            sender.sendMessage(str);
        }

//        switch (args[0]) {
//            case ""
//        }
        return false;
    }
}
