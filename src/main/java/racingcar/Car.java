package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int moveDistance;

    public Car() {
        moveDistance = 0;
    }

    public void move() {
        int moveVariance = Randoms.pickNumberInRange(0,9);
        if (moveVariance >= 4) {
            moveDistance += 1;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}
