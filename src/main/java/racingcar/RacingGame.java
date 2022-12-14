package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        List<Car> cars = inputView.inputCars()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());

        int tryCount = inputView.inputTryCount();
        outputView.printResult();
        // tryCount 대신 inputView.inputTryCount()를 매개변수로 주고 싶지만 printResult 구문 때문에 일단 분리
        racingByTryCount(cars, tryCount);

        List<Car> finalWinner = getFinalWinner(cars);
        outputView.printFinalWinner(finalWinner);
    }
    // racingByTryCount는 RacingGame에서 구현해야할 것 같은데 Cars에는 getter가 없기 때문에
    // for(Car car : Cars)를 사용할 수 없고, 차를 전진시킬 방법이 없다.

    public void racingByTryCount(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racing(cars);
            System.out.println();
        }
    }

    public List<Car> getFinalWinner(List<Car> cars) {
        final List<Car> finalWinner = new ArrayList<>();
        finalWinner.add(cars.remove(0));

        for (Car car : cars) {
            // for문 내용이 너무 지저분한데 정리할 수 있지 않을까?
            // value 변수명 뭘로 하지..
            int value = car.compareTo(finalWinner.get(finalWinner.size() - 1));
            if (value == 0) {
                finalWinner.add(car);
            }
            if (value > 0) {
                finalWinner.clear();
                finalWinner.add(car);
            }
        }
        return finalWinner;
    }

    public void racing(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward();
            // 일단 출력을 위해 어쩔 수 없이, 수정하자
            OutputView.printCarAndPosition(car);
        }
    }
}
