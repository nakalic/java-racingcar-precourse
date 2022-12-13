package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> inputCars() {
        // 여기서 검증을 해줘야 하나? 계속 입력 어떻게 받지?
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = Console.readLine().split(",");
        return new ArrayList<>(Arrays.asList(cars));
    }

    public int inputTryCount() {
        // TryCount 라는 클래스를 만드는 것은 오버엔지니어링일 것 같다.
        while(true) {
            try {
                System.out.println("시도할 회수는 몇회인가요?");
                String input = Console.readLine();
                validateTryCount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private void validateTryCount(String input) {
        checkNaturalNumber(input);
        checkOverThanZero(input);
    }

    private void checkNaturalNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("시도 횟수는 자연수여야합니다.");
        }
    }

    private void checkOverThanZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야합니다.");
        }
    }
}

