package racingcar;

import java.util.ArrayList;

public class Output {
    public static void printNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultByDegree(ArrayList<Car> cars) {
        System.out.println("\n실행 결과");
        for (Car car: cars) {
            System.out.printf("%s : ", car.getName());
            printDistance(car);
        }
    }

    private static void printDistance(Car car) {
        int distance = car.getMoveDistance();
        StringBuilder distanceResult = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            distanceResult.append('-');
        }
        System.out.println(distanceResult);
    }

    public static void printWinner(ArrayList<Car> winnerCars) {
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        for (Car car : winnerCars) {
            winners.append(car.getName())
                    .append(", ");
        }
        winners.setLength(winners.length() - 2);
        System.out.println(winners.toString());
    }
}