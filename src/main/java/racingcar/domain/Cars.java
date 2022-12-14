package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.OutputView;

public class Cars {

    final List<Car> cars;

    // 매개변수명 고민 !! (필드변수랑 이름이 같음 어떻게 짓지?)
    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void racingByTryCount(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racing();
            System.out.println();
        }
    }

    public List<Car> getFinalWinner() {
        final List<Car> finalWinner = new ArrayList<>();
        finalWinner.add(cars.remove(0));

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

    private void racing() {
        for (Car car : cars) {
            car.moveForward(Randoms.pickNumberInRange(0, 9));
            // 일단 출력을 위해 어쩔 수 없이, 수정하자
            OutputView.printCarAndPosition(car);
        }
    }
}
