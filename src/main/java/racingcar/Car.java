package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moveDistance;

    public Car(String name) {
        this.name = name;
        moveDistance = 0;
    }

    public void move() {
        int moveVariance = Randoms.pickNumberInRange(0,9);
        if (moveVariance >= 4) {
            moveDistance += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}
