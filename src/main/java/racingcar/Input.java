package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Input {
    private static final int MAX_NAME_LENGTH = 5;
    public static ArrayList<String> inputNames() {
        String input = Console.readLine();
        ArrayList<String> names = new ArrayList<>(Arrays.asList(input.split(",")));
        validateNames(names);
        return names;
    }

    public static int inputCount() {
        String input = Console.readLine();
        validateCount(input);
        return Integer.parseInt(input);
    }

    private static void validateNames(ArrayList<String> names) {
        boolean isNamesCorrect = names.stream().allMatch(name -> name.length() <= MAX_NAME_LENGTH);
        if (!isNamesCorrect) {
            throw new IllegalArgumentException("이름이 5자 이상임");
        }
    }

    private static void validateCount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자가 아님");
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }
}
