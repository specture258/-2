package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private final InputViewValidation inputViewValidation;

    public InputView(InputViewValidation inputViewValidation) {
        this.inputViewValidation = inputViewValidation;
    }

    public String inputCarName(){
        String carName = "";
        boolean validInput = false;

        while(!validInput){
            carName = readLine();
            validInput = inputViewValidation.validateCarNameLength(carName);
        }
        return carName;
    }

    public String inputTryCount(){
        String tryCount = "";
        boolean validInput = false;

         while(!validInput){
                tryCount = readLine();
             validInput = inputViewValidation.validateTryCountNumber(tryCount);
         }
         return tryCount;
    }

}
