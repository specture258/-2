package racingcar.controller;

import racingcar.domain.Car;
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

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void race(){
        init();
        run();
        end();
    }

    public void init() {
        outputView.inputCarName();
        carObject = getCarObject(inputView.inputCarName());

        outputView.inputTryCount();
        tryCount = Integer.parseInt(inputView.inputTryCount());
    }

    public void run(){
        outputView.result();
        while (tryCount >0) {
            getCarMoving();
            tryCount--;
            outputView.lineBreak();
        }
    }

    public void end(){
        outputView.finalWinner();
        getFinalWinner();
    }

    public List<Car> getCarObject(String cars){
        List<Car> carObject = new ArrayList<>();
        String[] carArray = cars.split(",");
        for(String carName : carArray){
            Car car = new Car(carName);
            carObject.add(car);
        }
        return carObject;
    }

    public void getCarMoving(){
        for (Car car : carObject) {
            outputView.carList(car);
            createCarMoving(car);
        }
    }

    public void createCarMoving(Car car){
        RandomNumber randomNumber = new RandomNumber();
        if(randomNumber.canMoving()){
            outputView.move(car);
            car.updatePosition();
        }
        else{
            outputView.status(car);
        }
    }

    public void getFinalWinner(){
        for (Car car : carObject) {
            positionList.add(car.getPosition());
        }
        createFinalWinner(Collections.max(positionList));
        outputView.finalWinnerName(String.join(", ", winnersList));
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
