package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 7})
    void 랜덤_값이_4이상이면_전진한다(final int randomNumber) {
        // given
        final RacingCar racingCar = new RacingCar();

        // when
        racingCar.move(randomNumber);

        // then
        assertThat(racingCar.getLocation()).isEqualTo(1);
    }
}
