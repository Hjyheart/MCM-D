package until;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hongjiayong on 2017/1/20.
 */
public class Passenger {
    private Integer id;
    private Integer arriveTime;
    private Integer exitTime;
    private Integer state;
    private Boolean isPre;
    private Integer doing;
    private FileWriter fileWriter;
    private Integer startA;
    private Integer endA;
    private Integer startB;
    private Integer endB;
    private Integer startC;
    private Integer endC;
    private Integer startD;
    private Integer endD;


    public Passenger(Integer id, Integer arriveTime, Integer state, Integer doing, Boolean isPre, FileWriter fileWriter){
        this.id = id;
        this.arriveTime = arriveTime;
        this.state = state;
        this.doing = doing;
        this.fileWriter = fileWriter;
        this.isPre = isPre;

        startA = 0;
        endA = 0;
        startB = 0;
        endB = 0;
        startC = 0;
        endC = 0;
        startD = 0;
        endD = 0;
    }

    /* for setting & getting */
    public Integer getId() {
        return id;
    }

    public Integer getStartA() {
        return startA;
    }

    public void setStartA(Integer startA) {
        this.startA = startA;
    }

    public Integer getEndA() {
        return endA;
    }

    public void setEndA(Integer endA) {
        this.endA = endA;
    }

    public Integer getStartB() {
        return startB;
    }

    public void setStartB(Integer startB) {
        this.startB = startB;
    }

    public Integer getEndB() {
        return endB;
    }

    public void setEndB(Integer endB) {
        this.endB = endB;
    }

    public Integer getStartC() {
        return startC;
    }

    public void setStartC(Integer startC) {
        this.startC = startC;
    }

    public Integer getEndC() {
        return endC;
    }

    public void setEndC(Integer endC) {
        this.endC = endC;
    }

    public Integer getStartD() {
        return startD;
    }

    public void setStartD(Integer startD) {
        this.startD = startD;
    }

    public Integer getEndD() {
        return endD;
    }

    public void setEndD(Integer endD) {
        this.endD = endD;
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

    public Boolean getPre() {
        return isPre;
    }

    public void setPre(Boolean pre) {
        isPre = pre;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    /* some method */
    public void writing() throws IOException {
        fileWriter.write(id + " " + arriveTime + " " + exitTime + " " + String.valueOf(endA - startA) + " " +
                String.valueOf(endB - startB) + " " + String.valueOf(endC - startC) + " " + String.valueOf(endD - startD) + "\n");
        fileWriter.flush();
    }
}
