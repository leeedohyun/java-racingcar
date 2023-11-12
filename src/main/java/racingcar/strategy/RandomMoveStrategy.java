package racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_MAX_BOUND = 10;
    private static final int CONDITION_NUMBER = 4;
    private static final Random random = new Random();

    @Override
    public boolean ableMove() {
        return random.nextInt(RANDOM_MAX_BOUND) >= CONDITION_NUMBER;
    }

}