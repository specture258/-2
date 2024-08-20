package racingcar.model.domain;

import racingcar.view.InputView;

public class TryCount {

    private int tryCount = 0;
    private final InputView inputView ;

    public TryCount(InputView inputView) {
        this.inputView = inputView;
    }

    public void createTryCount(){
        tryCount = Integer.parseInt(inputView.inputTryCount());
    }

    public int getTryCount() {
        return tryCount;
    }

    public void decreaseCount() {
        tryCount -= 1;
    }
}
