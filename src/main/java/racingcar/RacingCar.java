package racingcar;

import java.util.ArrayList;

public class RacingCar {
    private final ArrayList<Car> cars = new ArrayList<>();
    private int count;
    public void run() {
        setGame();
        playRace();
        outputWinner();
    }
    private void setGame() {
        Output.printNamesInputMessage();
        ArrayList<String> names = Input.inputNames();
        Output.printCountInputMessage();
        count = Input.inputCount();

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    private void playRace() {
        for(int i = 0; i < count; i++) {
            for (Car car: cars) {
                car.move();
            }
            Output.printResultByDegree(cars);
        }

    }

    private void outputWinner() {
        int maxDistance = 0;
        for (Car car : cars) {
            int distance = car.getMoveDistance();
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        ArrayList<Car> winnerCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getMoveDistance() == maxDistance) {
                winnerCars.add(car);
            }
        }
        Output.printWinner(winnerCars);
    }

    public ArrayList<Car> getCars() {
        return cars;
    }
}
