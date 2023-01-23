package nesb01t.monetdungeon.utils;

import java.util.Random;

public class MathUtils {
    public static int getRandomBetween(int x, int y) {
        Random random = new Random();
        return random.nextInt((y - x) + 1) + x;
    }

    public static boolean chanceOf(double chance) {
        Random random = new Random();
        double num = random.nextDouble() * 100;
        return (num <= chance);
    }
}
