package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public void run() {
        Cars cars = new Cars(inputView.inputCars()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList()));

        int tryCount = inputView.inputTryCount();
        outputView.printResult();
        // tryCount 대신 inputView.inputTryCount()를 매개변수로 주고 싶지만 printResult 구문 때문에 일단 분리
        cars.racingByTryCount(tryCount);

        List<Car> finalWinner = cars.getFinalWinner();
        outputView.printFinalWinner(finalWinner);
    }
    // racingByTryCount는 RacingGame에서 구현해야할 것 같은데 Cars에는 getter가 없기 때문에
    // for(Car car : Cars)를 사용할 수 없고, 차를 전진시킬 방법이 없다.
}
