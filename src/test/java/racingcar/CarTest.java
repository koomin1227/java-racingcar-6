package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class CarTest {
    private static MockedStatic<Randoms> randoms;
    @BeforeAll
    public static void beforeALl() {
        randoms = mockStatic(Randoms.class);
    }

    @AfterAll
    public static void afterAll() {
        randoms.close();
    }

    @Test
    void 자동차_이름을_설정() {
        Car car = new Car();

        car.setName("hello");

        assertThat(car.getName()).isEqualTo("hello");
    }

    @Test
    void 자동차_전진() {
        given(Randoms.pickNumberInRange(0,9)).willReturn(4);
        Car car = new Car();
        car.move();
        assertThat(car.getMoveDistance()).isEqualTo(1);
    }

    @Test
    void 자동차_정지() {
        given(Randoms.pickNumberInRange(0,9)).willReturn(3);
        Car car = new Car();
        car.move();
        assertThat(car.getMoveDistance()).isEqualTo(0);
    }
}
