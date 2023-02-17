package nesb01t.monetdungeon.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ManagerListener implements Listener {
    @EventHandler
    public void clickLocItem(InventoryClickEvent event) {
        ItemStack itemStack = event.getCurrentItem();

        // 点击物品是否有效
        if (itemStack == null) {
            return;
        }

        // 名字为Teleport Here，则取消事件
        String name = itemStack.getItemMeta().getDisplayName();
        if (!name.equals("Teleport Here")) {
            return;
        }
        event.setCancelled(true);

        // teleport To clickedLocation
        Player player = (Player) event.getWhoClicked();
        ItemMeta meta = itemStack.getItemMeta();
        List<String> lore = meta.getLore();
        String X = lore.get(1);
        String Y = lore.get(2);
        String Z = lore.get(3);
        player.sendMessage(X + Y + Z);
    }
}
