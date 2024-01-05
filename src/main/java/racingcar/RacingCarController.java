package racingcar;

import java.util.ArrayList;

public class RacingCarController {
    private RacingCarGame racingCarGame;
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

        racingCarGame = new RacingCarGame(names);
    }

    private void playRace() {
        for(int i = 0; i < count; i++) {
            ArrayList<Car> cars = racingCarGame.playRound();
            Output.printResultByDegree(cars);
        }
    }

    private void outputWinner() {
        ArrayList<String> winners = racingCarGame.getWinner();
        Output.printWinner(winners);
    }
}
