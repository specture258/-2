package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;
    private String statue = "";

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void updatePosition(){
        this.position++;
    }

    public int getPosition() {
        return position;
    }

    public String getStatue() {
        return statue;
    }

    public String move(){
       return statue += "-";
    }




}
