package racingcar;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        List<Car> cars = makeCars();
        makeTryCount(cars);
        makeFinalWinnerAndPrint(cars);
    }

    private void makeFinalWinnerAndPrint(List<Car> cars) {
        List<Car> finalWinner = getFinalWinner(cars);
        outputView.printFinalWinner(finalWinner);
    }

    private void makeTryCount(List<Car> cars) {
        int tryCount = inputView.inputTryCount();
        outputView.printResult();
        // tryCount 대신 inputView.inputTryCount()를 매개변수로 주고 싶지만 printResult 구문 때문에 일단 분리
        racingByTryCount(cars, tryCount);
    }

    private List<Car> makeCars() {
        return inputView.inputCars()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void racingByTryCount(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racing(cars);
            System.out.println();
        }
    }

    private List<Car> getFinalWinner(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                //.orElseThrow 사용하면 반환값 OptionalInt -> int 변경
                .orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(car -> maxPosition == car.getPosition())
                .collect(Collectors.toList());
    }

    private void racing(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
            OutputView.printCarAndPosition(car);
        }
    }
}
