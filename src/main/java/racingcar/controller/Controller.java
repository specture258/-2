package racingcar.controller;

import racingcar.domain.*;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Controller {


    private List<Car> carObject;
    private final List<String> winnersList = new ArrayList<>();
    private final List<Integer> positionList = new ArrayList<>();
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
        carObject = carService.getCarObject();

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
        getFinalWinner();
    }

    public void getFinalWinner(){
        for (Car car : carObject) {
            positionList.add(car.getPosition());
        }
        createFinalWinner(Collections.max(positionList));
        OutputView.printFinalWinnerName(String.join(", ", winnersList));
    }

    private void createFinalWinner(Integer maxPosition) {
        for(int i=0 ; i<positionList.size() ;i++){
            Car car = carObject.get(i);
            if(positionList.get(i).equals(maxPosition)){
                winnersList.add(car.toString());
            }
        }
    }
}
