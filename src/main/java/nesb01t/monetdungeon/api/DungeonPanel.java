package nesb01t.monetdungeon.api;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.IOException;
import java.util.List;

import static nesb01t.monetdungeon.MonetDungeon.plugin;

public class DungeonPanel {

    public static void openDungeonPanel(Player player) throws IOException {
        // 打开地牢面板
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            Inventory panelInv = getPanelInv(player);
            player.openInventory(panelInv);
        }, 2L);
    }

    private static Inventory getPanelInv(Player player) {
        // 创建 Inv
        Inventory panelInv = Bukkit.createInventory(player, 27, "传送门");

        return panelInv;
    }

    private static ItemStack createTeleportItem(Material material, String name, List<String> lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);
        return itemStack;
    }
}
