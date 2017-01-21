package controller;

import until.Passenger;

import java.io.FileWriter;
import java.util.ArrayList;
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
        int count = 0;
        for (int i = 0; i < 75000; i++){
            // TODO: 泊松流
            count += (int)(-1.152 * Math.log(Math.random()));
            dl.add(count);
        }
    }

    public Integer getPassengerCounter() {
        return passengerCounter;
    }

    public void setPassengerCounter(Integer passengerCounter) {
        this.passengerCounter = passengerCounter;
    }

    public ArrayList<Passenger> getPassenger(Integer time){
        ArrayList<Passenger> passengers = new ArrayList<>();
//        System.out.println(time.compareTo(dl.peek()));
        while (!dl.isEmpty() && time.compareTo(dl.peek()) == 0){
            dl.poll();
            Passenger passenger;
            if (Math.random() * 100 <= 45){
                passenger = new Passenger(passengerCounter, time, 0, 0, true, fileWriter);
            }else{
                passenger = new Passenger(passengerCounter, time, 0, 0, false, fileWriter);
            }
            passengerCounter++;
            passengers.add(passenger);
        }

        return passengers;
    }


}
