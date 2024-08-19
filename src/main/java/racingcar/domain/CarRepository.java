package racingcar.domain;

import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private final InputView inputView;

    public CarRepository(InputView inputView) {
        this.inputView = inputView;
    }

    public String[] createCarObject(){
        String cars = inputView.inputCarName();
        String[] carArray = cars.split(",");
        return carArray;

    }





}
