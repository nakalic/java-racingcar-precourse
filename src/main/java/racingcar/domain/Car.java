package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameSize(name);
        this.name = name;
    }

    public void moveForward(int number) {
        if (number >= 4) {
            this.position += 1;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    public String getNowPosition() {
        String nowPosition = "";
        for (int i = 0; i < position; i++) {
            nowPosition += "-";
        }
        return nowPosition;
    }

    private void validateNameSize(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
