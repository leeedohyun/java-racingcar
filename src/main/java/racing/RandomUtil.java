package racing;

import java.util.Random;

public class RandomUtil {

    public static int returnRandomNumber() {
        return new Random().nextInt(10);
    }
}