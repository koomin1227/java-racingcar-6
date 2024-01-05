package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

public class InputTest {
    private static MockedStatic<Console> console;
    @BeforeAll
    public static void beforeALl() {
        console = mockStatic(Console.class);
    }

    @AfterAll
    public static void afterAll() {
        console.close();
    }
    @Test
    void 이름_3개_입력() {
        given(Console.readLine()).willReturn("qwe,asd,zxc");
        ArrayList<String> res = Input.inputNames();
        assertThat(res.size()).isEqualTo(3);
    }

    @Test
    void 이름의_길이가_6이상일때_예외_발생() {
        given(Console.readLine()).willReturn("qwe,123456,zxc");
        assertThatThrownBy(Input::inputNames)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 5자 이상임");
    }

    @Test
    void 시도할_회수_입력() {
        given(Console.readLine()).willReturn("123");
        int res = Input.inputCount();
        assertThat(res).isEqualTo(123);
    }

    @Test
    void 시도할_회수가_숫자가_아닌_경우_예외_발생() {
        given(Console.readLine()).willReturn("12asd");
        assertThatThrownBy(Input::inputCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아님");
    }
}
