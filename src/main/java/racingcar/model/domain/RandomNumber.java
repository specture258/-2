package racingcar.model.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RandomNumber {

    private int MIN_RANGE = 0;
    private int MAX_RANGE = 9;
    private int THRESHOLD = 4;

    public int createRandomNumber() {
       return pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }

    public boolean canMoving(){
        if(createRandomNumber() >= THRESHOLD){
            return true;
        }
        return false;
    }
}
