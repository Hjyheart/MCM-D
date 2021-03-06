package until;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hongjiayong on 2017/1/20.
 */
public class PointA extends Point {
    private FileWriter fileWriterWaiting;
    private FileWriter fileWriterPassing;
    private BArea next;
    private ArrayList<Passenger> dealPassengers;
    private Integer countPassenger;

    public PointA(Integer name, BArea pointBPre, FileWriter fileWriterWaiting, FileWriter fileWriterPassing) {
        super(name);
        next = pointBPre;
        countPassenger = 0;
        this.fileWriterPassing = fileWriterPassing;
        this.fileWriterWaiting = fileWriterWaiting;
        dealPassengers = new ArrayList<>();
    }

    @Override
    public void action(Boolean flag, Integer time){

        while(getWaitingList().size() != 0 && dealPassengers.size() < 11){
            Passenger passenger = getWaitingList().poll();

            passenger.setDoing(((int) ( (Math.round(Math.random() * 8) + 7))));
            dealPassengers.add(passenger);
        }


        ArrayList<Passenger> temp = new ArrayList<>();

        for (Passenger passenger : dealPassengers){
            temp.add(passenger);
        }

        for (Passenger passenger : temp){
            deal(passenger, time);
        }

        // record
        try {
            fileWriterWaiting.write(String.valueOf(getWaitingList().size()) + "\n");
            fileWriterWaiting.flush();
            if (flag){
                fileWriterPassing.write(String.valueOf(countPassenger) + "\n");
                fileWriterPassing.flush();
                countPassenger = 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deal(Passenger passenger, Integer time){
        if (passenger != null){
            if (passenger.getDoing() > 0){
                passenger.setDoing(passenger.getDoing() - 1);
            }else{
                countPassenger++;
                passenger.setEndA(time);
                passenger.setStartB(time);
                if (passenger.getPre()){
                    // Pre
                    next.getBsPre().get(gotoB(6)).add(passenger);
                }else{
                    // regular
                    next.getBs().get(gotoB(18)).add(passenger);
                }
                for (int i = 0; i < dealPassengers.size(); i++){
                    if (dealPassengers.get(i).equals(passenger)){
                        dealPassengers.remove(i);
                        break;
                    }
                }
            }
        }
    }

    public Integer gotoB(int n){
        Integer num = (int) (Math.random() * n);
        return num;
    }

}
