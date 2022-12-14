package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car>{
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameSize(name);
        this.name = name;
    }

    public void moveForward() {
        if (Randoms.pickNumberInRange(1, 4) >= 4) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    // 지우고 getName 쓰는게 낫나?
    @Override
    public String toString() {
        return name;
    }

    private void validateNameSize(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }

    @Override
    public int compareTo(Car car) {
        return this.position- car.position;
    }
}
