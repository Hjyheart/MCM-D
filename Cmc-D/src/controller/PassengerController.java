package controller;

import until.Passenger;

import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by hongjiayong on 2017/1/21.
 */
public class PassengerController {
    private Integer passengerCounter;
    private Queue<Integer> dl;
    private FileWriter fileWriter;

    public PassengerController(FileWriter fileWriter){
        this.fileWriter = fileWriter;
        passengerCounter = 0;
        dl = new LinkedList<>();

        for (int i = 0; i < 80000; i++){
            // TODO: 泊松流
        }
    }

    public Integer getPassengerCounter() {
        return passengerCounter;
    }

    public void setPassengerCounter(Integer passengerCounter) {
        this.passengerCounter = passengerCounter;
    }

    public Passenger getPassenger(Integer time){
        if (time == dl.peek()){
            dl.poll();
            Passenger passenger = new Passenger(passengerCounter, time, 0, 0, fileWriter);
            return passenger;
        }else{
            return null;
        }
    }


}
