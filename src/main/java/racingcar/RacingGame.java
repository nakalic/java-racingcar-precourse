package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class RacingGame {
    private void racingByTryCount(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racing(cars);
            System.out.println();
        }
    }

    private void racing(List<Car> cars) {
        for (Car car : cars) {
            car.moveForward(Randoms.pickNumberInRange(0, 9));
            System.out.print(car + " : " + car.getNowPosition());
            System.out.println();
        }
    }
}
