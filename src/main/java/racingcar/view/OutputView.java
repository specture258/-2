package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    public void inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void inputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult(){
        System.out.println("실행 결과");
    }

    public void printCarList(Car car){
        System.out.print(car.toString() + " : ");
    }

    public void printStatus(Car car){
        System.out.println(car.getStatue());
    }

    public void printMoving(Car car){
        System.out.println(car.move());
    }

    public void printLineBreak(){
        System.out.println();
    }

    public void printFinalWinner(){
        System.out.print("최종 우승자 : ");
    }

    public void printFinalWinnerName(String winners){
        System.out.print(winners);
    }


}
