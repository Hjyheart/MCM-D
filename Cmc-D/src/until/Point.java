package until;

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
    public void action(){

//        if (waitingList.peek().getDoing() > 0){
//            waitingList.peek().setDoing(waitingList.peek().getDoing() - 1);
//        }else{
//
//        }
//
//        for (until.Passenger passenger : waitingList){
//            Integer waitingTime = passenger.getWaitingList().get(name);
//            passenger.getWaitingList().set(name, waitingTime++);
//        }
    }

    public void add(Passenger passenger){
        waitingList.add(passenger);
    }
}
