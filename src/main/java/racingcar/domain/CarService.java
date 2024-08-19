package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    List<Car> carObject = new ArrayList<>();

    public List<Car> getCarObject(){
        String[] carArray = carRepository.createCarObject();

        for(String carName : carArray){
            Car car = new Car(carName);
            carObject.add(car);
        }

        return carObject;
    }

    public void getCarMoving(){

        for (Car car : carObject) {
            outputView.printCarList(car);
            createCarMoving(car);
        }
    }

    public void createCarMoving(Car car){
        RandomNumber randomNumber = new RandomNumber();
        if(randomNumber.canMoving()){
            outputView.printMoving(car);
            car.updatePosition();
        }
        else{
            outputView.printStatus(car);
        }
    }

}
