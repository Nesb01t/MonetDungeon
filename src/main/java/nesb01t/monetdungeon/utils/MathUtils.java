package nesb01t.monetdungeon.utils;

import java.util.Random;

public class MathUtils {
    // 获取一个x~y区间内的随机值
    public static int getRandomBetween(int x, int y) {
        Random random = new Random();
        return random.nextInt((y - x) + 1) + x;
    }

    // chance几率返回True
    public static boolean chanceOf(double chance) {
        Random random = new Random();
        double num = random.nextDouble() * 100;
        return (num <= chance);
    }
}
