package until;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hongjiayong on 2017/1/20.
 */
public class Passenger {
    private Integer id;
    private Integer arriveTime;
    private Integer exitTime;
    private Integer state;
    private Integer doing;
    private FileWriter fileWriter;
    private ArrayList<Integer> waitingList;

    public Passenger(Integer id, Integer arriveTime, Integer state, Integer doing, FileWriter fileWriter){
        this.id = id;
        this.arriveTime = arriveTime;
        this.state = state;
        this.doing = doing;
        this.fileWriter = fileWriter;

        waitingList = new ArrayList<>();
        for (int i = 0 ; i < 4; i++){
            waitingList.add(0);
        }
    }

    /* for setting & getting */
    public Integer getId() {
        return id;
    }

    public ArrayList<Integer> getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(ArrayList<Integer> waitingList) {
        this.waitingList = waitingList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Integer arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Integer getExitTime() {
        return exitTime;
    }

    public void setExitTime(Integer exitTime) {
        this.exitTime = exitTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getDoing() {
        return doing;
    }

    public void setDoing(Integer doing) {
        this.doing = doing;
    }

    /* some method */
    public void writing() throws IOException {
        fileWriter.write(id + " " + arriveTime + " " + exitTime + " " + waitingList.get(0) + " " +
                waitingList.get(1) + " " + waitingList.get(2) + " " + waitingList.get(3));
        fileWriter.flush();
    }
}
