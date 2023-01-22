package nesb01t.monetdungeon.API;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

public class MapBlock {
    public static int getMapBlockX(LivingEntity entity) {
        int xCoordinate = entity.getLocation().getBlockX();
        int xBlock = (xCoordinate + 500) / 1000;
        return xBlock;
    }

    public static int getMapBlockZ(LivingEntity entity) {
        int zCoordinate = entity.getLocation().getBlockY();
        int zBlock = (zCoordinate + 500) / 1000;
        return zBlock;
    }


}
