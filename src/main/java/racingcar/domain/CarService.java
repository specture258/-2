package racingcar.domain;

import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    List<Car> carObject = new ArrayList<>();

    public List<Car> getCarObject(){
        String[] carArray = carRepository.createCarArray();

        for(String carName : carArray){
            Car car = new Car(carName);
            carObject.add(car);
        }
        return carObject;
    }

    public void getCarMoving(){
        for (Car car : carObject) {
            OutputView.printCarList(car);
            createCarMoving(car);
        }
    }

    public void createCarMoving(Car car){
        RandomNumber randomNumber = new RandomNumber();
        if(randomNumber.canMoving()){
            OutputView.printMoving(car);
            car.updatePosition();
        }
        OutputView.printStatus(car);
    }

}
