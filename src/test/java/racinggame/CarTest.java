package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("자동차가 이동할 수 있다.")
    void forward() {
        // given
        Car car = new Car("pobi");

        // when
        car.forward();
        int status = car.getStatus();

        // then
        assertThat(status).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 100})
    @DisplayName("숫자가 4이상이면 이동할 수 있다.")
    void 값이_4이상(int value) {
        Car car = new Car("pobi");
        int nowStatus = car.getStatus();

        car.move(value);

        assertThat(car.getStatus()).isGreaterThan(nowStatus);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("숫자가 4미만이면 이동할 수 없다.")
    void 값이_4미만(int value) {
        Car car = new Car("pobi");
        int nowStatus = car.getStatus();

        car.move(value);

        assertThat(car.getStatus()).isEqualTo(nowStatus);
    }

    @ParameterizedTest
    @ValueSource(strings = {"booooooo", "dfsfgfd", "csdffdgfdg"})
    @DisplayName("자동차 이름은 5글자를 초과할 수 없다.")
    void 이름이_5미만(String value) {
        assertThatThrownBy(() -> new Car(value))
                .isInstanceOf(RuntimeException.class);
    }
}
