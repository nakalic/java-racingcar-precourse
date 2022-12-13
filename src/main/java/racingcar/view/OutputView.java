package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    public void printCarAndPosition(Car car) {
        System.out.print(car + " : " + car.getNowPosition());
        System.out.println();
    }
}
