package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovementTest {
    private List<Car> cars;
    private Movement movement;

    @BeforeEach
    void setUp() {
        Car car1 = new Car();
        cars = Arrays.asList(car1);

        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy();
        movement = new Movement(cars, randomMoveStrategy);
    }

    @Test
    @DisplayName("moveCars에 조건에 해당하는 경우 차가 이동하는지 확인")
    void moveCarsTest() {
        // given
        int initialTrace = cars.get(0).getTrace();
        int traceIfMoved = initialTrace + 1;

        // when
        movement.moveCars();

        // then
        assertThat(cars.get(0).getTrace()).isBetween(initialTrace, traceIfMoved);
    }
}