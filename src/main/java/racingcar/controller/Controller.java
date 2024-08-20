package racingcar.controller;

import racingcar.model.domain.TryCount;
import racingcar.model.service.CarService;
import racingcar.view.OutputView;

public class Controller {

    private final CarService carService;
    private final TryCount tryCount;

    public Controller(CarService carService, TryCount tryCount) {
        this.carService = carService;
        this.tryCount = tryCount;
    }

    public void race(){
        init();
        run();
        end();
    }

    public void init() {
        OutputView.inputCarName();
        carService.getCarObject();

        OutputView.inputTryCount();
        tryCount.createTryCount();
    }

    public void run(){
        OutputView.printResult();
        while (tryCount.getTryCount() >0) {
            carService.getCarMoving();
            tryCount.decreaseCount();
            OutputView.printLineBreak();
        }
    }

    public void end(){
        OutputView.printFinalWinner();
        carService.getFinalWinner();
    }
}
