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

    public int inputTryCount() {
        // TryCount 라는 클래스를 만드는 것은 오버엔지니어링일 것 같다.
        String input = Console.readLine();
        validateTryCount(input);
        return Integer.parseInt(input);
    }

    private void validateTryCount(String input) {
        checkNaturalNumber(input);
        checkOverThanZero(input);
    }

    private void checkNaturalNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야합니다.");
        }
    }

    private void checkOverThanZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야합니다.");
        }
    }
}

