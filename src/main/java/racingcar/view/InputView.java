package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> inputCars() {
        String[] cars = Console.readLine().split(",");
        return new ArrayList<>(Arrays.asList(cars));
    }
}
