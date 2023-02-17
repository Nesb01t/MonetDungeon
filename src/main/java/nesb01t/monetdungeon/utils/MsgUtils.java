package nesb01t.monetdungeon.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MsgUtils {
    public static void Send(Player player, String prefix, String msg) {
        String sendMsg = "&c" + prefix + " &f&l>&7&l> &7" + msg;
        sendMsg = ChatColor.translateAlternateColorCodes('&', sendMsg);
        player.sendMessage(sendMsg);
    }
}
