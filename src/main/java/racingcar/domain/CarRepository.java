package racingcar.domain;

import racingcar.view.InputView;


public class CarRepository {

    private final InputView inputView;

    public CarRepository(InputView inputView) {
        this.inputView = inputView;
    }

    public String[] createCarArray(){
        String cars = inputView.inputCarName();
        return cars.split(",");
    }
}
