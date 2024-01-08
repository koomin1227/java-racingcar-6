package racingcar;

import java.util.ArrayList;

public class RacingCarGame {
    private final ArrayList<Car> cars;

    public RacingCarGame(ArrayList<String> names) {
        cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public ArrayList<Car> playRound() {
        for (Car car : cars) {
            car.move();
        }
        return cars;
    }

    public ArrayList<String> getWinner() {
        int maxDistance = 0;
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            int distance = car.getMoveDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
                winners.clear();
                winners.add(car.getName());
            } else if (distance == maxDistance) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
