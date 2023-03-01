package nesb01t.monetdungeon.api;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static nesb01t.monetdungeon.MonetDungeon.plugin;

public class DungeonPanel {

    private static final int itemStartIndex = 10;

    /**
     * 呈现给玩家的传送门 GUI 面板
     *
     * @param player
     * @return
     */
    private static Inventory getPanelInv(Player player) {
        // init inventory
        List<String> lore;
        ItemStack item;
        int level;
        Inventory panelInv = Bukkit.createInventory(player, 27, "传送门");

        // 森林
        lore = geneTeleportItemLore(1, "一片古老的原始森林.");
        item = geneTeleportItem(Material.GRASS_BLOCK, "永歌森林", lore);
        panelInv.setItem(itemStartIndex, item);

        // 洞穴
        lore = geneTeleportItemLore(15, "幽暗的废弃矿工洞穴.");
        item = geneTeleportItem(Material.COBBLESTONE, "迷失矿坑", lore);
        panelInv.setItem(itemStartIndex + 1, item);
        return panelInv;
    }

    // 异步打开地牢面板
    public static void openDungeonPanel(Player player) throws IOException {
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.scheduleSyncDelayedTask(plugin, () -> {
            Inventory panelInv = getPanelInv(player);
            player.openInventory(panelInv);
        }, 2L);
    }

    // 生成传送物品
    private static ItemStack geneTeleportItem(Material material, String name, List<String> lore) {
        // init itemStack
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        name = ChatColor.translateAlternateColorCodes('&', "&f&l◉ &f" + name + " &8TeleItem");
        itemMeta.setDisplayName(name);
        itemMeta.setLore(lore);

        // return itemStack
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    // 生成传送物品 Lore
    private static List<String> geneTeleportItemLore(int level, String discribe) {
        List<String> lore = new ArrayList<>();
        lore.add("&a副本等级 &f&l>&7&l> &7" + level);
        lore.add("&a地图元素 &f&l>&7&l> &7" + discribe);

        // text color
        for (int i = 0; i < lore.size(); i++) {
            String line = lore.get(i);
            line = ChatColor.translateAlternateColorCodes('&', line);
            lore.set(i, line);
        }
        return lore;
    }
}
