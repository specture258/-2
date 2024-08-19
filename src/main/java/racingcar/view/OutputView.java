package racingcar.view;

import racingcar.domain.Car;

public class OutputView {

    public static void inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void inputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResult(){
        System.out.println("실행 결과");
    }

    public static void printCarList(Car car){
        System.out.print(car.toString() + " : ");
    }

    public static void printStatus(Car car){
        System.out.println(car.getStatue());
    }

    public static void printMoving(Car car){
        System.out.print(car.move());
    }

    public static void printLineBreak(){
        System.out.println();
    }

    public static void printFinalWinner(){
        System.out.print("최종 우승자 : ");
    }

    public static void printFinalWinnerName(String winners){
        System.out.print(winners);
    }


}
