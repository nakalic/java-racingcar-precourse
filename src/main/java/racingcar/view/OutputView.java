package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCarAndPosition(Car car) {
        System.out.print(car + " : " + car.getNowPosition());
        System.out.println();
    }
}
