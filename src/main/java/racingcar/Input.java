package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;

public class Input {
    public static ArrayList<String> inputNames() {
        String input = Console.readLine();
        ArrayList<String> names = new ArrayList<>(Arrays.asList(input.split(",")));
        validateNames(names);
        return names;
    }

    private static void validateNames(ArrayList<String> names) {
        boolean isNamesCorrect = names.stream().allMatch(name -> name.length() <= 5);
        if (!isNamesCorrect) {
            throw new IllegalArgumentException("이름이 5자 이상임");
        }
    }
}
