package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

public class RacingCarGameTest {
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
    void RacingCarGame_생성() {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            names.add("test".concat(Integer.toString(i)));
        }

        RacingCarGame racingCarGame = new RacingCarGame(names);
        ArrayList<Car> cars = racingCarGame.getCars();
        assertThat(cars.size()).isEqualTo(5);
    }

    @Test
    void 한턴_진행() {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            names.add("test".concat(Integer.toString(i)));
        }
        given(Randoms.pickNumberInRange(0,9)).willReturn(4);
        RacingCarGame racingCarGame = new RacingCarGame(names);
        ArrayList<Car> cars = racingCarGame.playRound();
        boolean res = cars.stream().allMatch(car -> car.getMoveDistance() == 1);
        assertThat(res).isEqualTo(true);
    }

    @Test
    void 우승자_반환() {
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            names.add("test".concat(Integer.toString(i)));
        }
        RacingCarGame racingCarGame = new RacingCarGame(names);
        ArrayList<String> winners = racingCarGame.getWinner();
        assertThat(winners.size()).isEqualTo(3);
    }
}
