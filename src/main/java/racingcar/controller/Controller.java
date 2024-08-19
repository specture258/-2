package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.domain.CarService;
import racingcar.domain.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private int tryCount = 0;
    private List<Car> carObject;
    private final List<String> winnersList = new ArrayList<>();
    private final List<Integer> positionList = new ArrayList<>();
    private final CarService carService;

    public Controller(InputView inputView, OutputView outputView, CarService carService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carService = carService;
    }

    public void race(){
        init();
        run();
        end();
    }

    public void init() {
        outputView.inputCarName();
        carObject = carService.getCarObject();

        outputView.inputTryCount();
        tryCount = Integer.parseInt(inputView.inputTryCount());
    }

    public void run(){
        outputView.printResult();
        while (tryCount >0) {
            carService.getCarMoving();
            tryCount--;
            outputView.printLineBreak();
        }
    }

    public void end(){
        outputView.printFinalWinner();
        getFinalWinner();
    }

    public void getFinalWinner(){
        for (Car car : carObject) {
            positionList.add(car.getPosition());
        }
        createFinalWinner(Collections.max(positionList));
        outputView.printFinalWinnerName(String.join(", ", winnersList));
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
