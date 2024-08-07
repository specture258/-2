package racingcar;

import racingcar.controller.Controller;
import racingcar.view.InputView;
import racingcar.view.InputViewValidation;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        Controller game = new Controller(new InputView(new InputViewValidation()), new OutputView());
        game.race();
    }
}
