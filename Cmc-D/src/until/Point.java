package until;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hongjiayong on 2017/1/20.
 */
public class Point {
    private Integer name;
    private Queue<Passenger> waitingList;

    public Point(Integer name){
        this.name = name;
        waitingList = new LinkedList<>();
    }

    /* for setting & getting */
    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Queue<Passenger> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(Queue<Passenger> waitingList) {
        this.waitingList = waitingList;
    }

    /* some method */
    public void action(Boolean flag, Integer time) throws IOException {

    }

    public void add(Passenger passenger){
        waitingList.add(passenger);
    }
}
