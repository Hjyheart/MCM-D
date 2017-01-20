package controller;

/**
 * Created by hongjiayong on 2017/1/21.
 */
public class TimeController {
    private Integer timeCounter;

    public TimeController(){
        timeCounter = 0;
    }

    public Integer getTimeCounter() {
        return timeCounter;
    }

    public void setTimeCounter(Integer timeCounter) {
        this.timeCounter = timeCounter;
    }

    public void tick(){
        timeCounter++;
    }
}
