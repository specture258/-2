package racingcar.view;

public class InputViewValidation {

    public boolean validateCarNameLength(String carName) {
        try{
            carNameLengthIsCorrect(carName);
            return true;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validateTryCountNumber(String tryCountNumber) {
        try{
            tryCountNumberIsNumber(tryCountNumber);
            return true;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void tryCountNumberIsNumber(String tryCountNumber) {
        for(char c : tryCountNumber.toCharArray()){
            if(c < '0' || c > '9') {
                throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
            }
        }
    }

    public void carNameLengthIsCorrect(String carName) {
        int LIMIT_LENGTH = 5;
        String[] cars = carName.split(",");
        for(String car : cars){
            if(car.length() > LIMIT_LENGTH){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하여야한다.");
            }
        }
    }



}
