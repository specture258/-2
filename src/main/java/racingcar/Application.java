package racingcar;

import racingcar.controller.Controller;
import racingcar.model.repository.CarRepository;
import racingcar.model.service.CarService;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.InputViewValidation;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행

        Controller game = new Controller(new CarService(new CarRepository(new InputView(new InputViewValidation()))),
                new TryCount(new InputView(new InputViewValidation())));
        game.race();
    }
}
