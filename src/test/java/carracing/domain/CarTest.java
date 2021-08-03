package carracing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("자동차의 위치가 자동차에 저장되어있어야 한다.")
    void carLocationTest() {

        // given
        Car car = new Car();

        // whe & then
        assertThat(car.location()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 이동할 수 있다.")
    void forwardCarTest() {

        // given
        Car car = new Car();

        // when
        car.forward();

        // then
        assertThat(car.location()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8, 10})
    @DisplayName("입력값이 4이상이 들어오면 자동차는 이동해야 한다.")
    void moveSuccessTest(int cmd) {

        // given
        Car car = new Car();

        // when
        int result = car.move(cmd);

        // then
        assertThat(result).isEqualTo(1);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("입력값이 3이하가 들어오면 자동차는 이동하지 않는다.")
    void moveFailTest(int cmd) {

        // given
        Car car = new Car();

        // when
        int result = car.move(cmd);

        // then
        assertThat(result).isEqualTo(0);
    }

}