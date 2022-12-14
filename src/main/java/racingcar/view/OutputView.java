package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    static public void printCarAndPosition(Car car) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append("-");
        }
        System.out.print(car + " : " + stringBuilder);
        System.out.println();
    }

    public void printFinalWinner(List<Car> cars) {
        // final?
        StringBuilder carNames = new StringBuilder();
        cars.forEach(car -> {
            carNames.append(car);
            carNames.append(", ");
        });
        carNames.delete(carNames.length() - 2, carNames.length() - 1);
        System.out.print("최종 우승자 : " + carNames);
    }
}
