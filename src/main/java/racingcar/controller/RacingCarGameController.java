package racingcar.controller;

import racingcar.exception.IllegalArgumentException;
import racingcar.model.CarNames;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGameController {
    public static final String REQUEST_INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (각 자동차는 5글자 이하 쉼표(,) 기준으로 입력해주세요.)";
    public static final String REQUEST_INPUT_ROUND = "시도할 회수는 몇회인가요?";

    private final OutputView outputView = new OutputView();
    private final Round round;
    public RacingCarGameController() {
        CarNames names = getValidCarNames();
        this.round = validRound();
    }

    public void run() {
    }

    private CarNames getValidCarNames() {
        boolean checkNames;
        String userInput;

        do {
            outputView.notice(REQUEST_INPUT_CAR_NAME);
            userInput = InputView.getUserInput();
            checkNames = checkCarNamesUserInput(userInput);
        } while (!checkNames);

        return new CarNames(userInput);
    }

    private boolean checkCarNamesUserInput(String userinput) {
        try {
            new CarNames(userinput);
            return true;
        } catch (IllegalArgumentException e) {
            outputView.error(e);
            return false;
        }
    }

    private Round validRound () {
        boolean isValid;
        String userInput;

        do {
            outputView.notice(REQUEST_INPUT_ROUND);
            userInput = InputView.getUserInput();
            isValid = checkRoundUserInput(userInput);
        } while (!isValid);

        return new Round(userInput);
    }

    private boolean checkRoundUserInput(String userinput) {
        try {
            new Round(userinput);
            return true;
        } catch (IllegalArgumentException e) {
            outputView.error(e);
            return false;
        }
    }
}
