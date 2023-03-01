package nesb01t.monetdungeon.api;

import nesb01t.monetdungeon.utils.YamlUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DungeonManager {
    public static void openDungeonManager(Player player, String blockX) throws IOException {
        // 打开地牢面板
        Inventory panelInv = getManagerInv(player, blockX);
        player.openInventory(panelInv);
    }


    private static Inventory getManagerInv(Player player, String blockX) throws IOException {
        // createInv
        Inventory panelInv = Bukkit.createInventory(player, 27, "地图区块: " + blockX);
        YamlConfiguration yaml = YamlUtils.useYamlFile(String.valueOf(blockX));

        // appendItems
        for (int i = 1; i <= 3; i++) { // level
            String level = String.valueOf(i);
            int size = YamlUtils.getListSize(blockX, level);

            for (int j = 0; j < size; j++) { // index
                String index = String.valueOf(j);
                int chestIndex = (i - 1) * 9 + j;

                Location loc = LocFileParser.getLocation(blockX, level, index); // 获取坐标
                ItemStack itemStack = generateLocItem(loc, level);
                panelInv.setItem(chestIndex, itemStack);
            }
        }


        return panelInv;
    }

    private static ItemStack generateLocItem(Location location, String level) {
        // getMaterial
        Material material = Material.GRASS_BLOCK;
        switch (level) {
            case "1":
                material = Material.OBSIDIAN;
                break;
            case "2":
                material = Material.DIORITE;
                break;
            case "3":
                material = Material.MAGMA_BLOCK;
                break;
        }

        // getItemMeta
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        // setItemMeta
        itemMeta.setDisplayName("Teleport Here"); // name
        List<String> lore = new ArrayList<>(); // lore
        lore.add("地图层级: " + level);
        lore.add("X坐标: " + location.getX());
        lore.add("Y坐标: " + location.getY());
        lore.add("Z坐标: " + location.getZ());
        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return itemStack;
    }
}
