package racingcar.model.service;

import racingcar.model.domain.Car;
import racingcar.model.repository.CarRepository;
import racingcar.model.domain.RandomNumber;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private final List<Car> carObject = new ArrayList<>();
    private final List<String> winnersList = new ArrayList<>();
    private final List<Integer> positionList = new ArrayList<>();

    public void getCarObject(){
        String[] carArray = carRepository.createCarArray();

        for(String carName : carArray){
            Car car = new Car(carName);
            carObject.add(car);
        }
    }

    public void getCarMoving(){
        for (Car car : carObject) {
            OutputView.printCarList(car);
            createCarMoving(car);
        }
    }

    private void createCarMoving(Car car){
        RandomNumber randomNumber = new RandomNumber();
        if(randomNumber.canMoving()){
            OutputView.printMoving(car);
            car.updatePosition();
            return;
        }
        OutputView.printStatus(car);
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
