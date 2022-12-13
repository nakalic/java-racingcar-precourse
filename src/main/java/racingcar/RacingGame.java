package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    private void racingByTryCount(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racing(cars);
            System.out.println();
        }
    }

    private void racing(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward(Randoms.pickNumberInRange(0, 9));
            outputView.printCarAndPosition(car);
        }
    }

    private List<Car> getFinalWinner(List<Car> cars) {
        final List<Car> finalWinner = new ArrayList<>();
        // List<Car> 요소의 첫번째를 add 하고 싶은데 어떻게 해야할까?
        finalWinner.add(new Car("a"));

        for (Car car : cars) {
            // for문 내용이 너무 지저분한데 정리할 수 있지 않을까?
            // value 변수명 뭘로 하지..
            int value = car.compareCarPosition(finalWinner.get(finalWinner.size() - 1));
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
}
