package until;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hongjiayong on 2017/1/20.
 */
public class PointD extends Point {
    private FileWriter fileWriterWaiting;
    private FileWriter fileWriterPassing;
    private ArrayList<Passenger> dealPassengers;
    private Integer countPassenger;
    public PointD(Integer name, FileWriter fileWriterWaiting, FileWriter fileWriterPassing) {
        super(name);
        this.fileWriterPassing = fileWriterPassing;
        this.fileWriterWaiting = fileWriterWaiting;
        dealPassengers = new ArrayList<>();
        countPassenger = 0;
    }

    @Override
    public void action(Boolean flag, Integer time) throws IOException {
        while(getWaitingList().size() != 0 && dealPassengers.size() < 4){
            Passenger passenger = getWaitingList().poll();
            // TODO:对时间取一个范围随机数
            passenger.setDoing(60);
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

    public void deal(Passenger passenger, Integer time) throws IOException {
        if (passenger != null){
            if (passenger.getDoing() > 0){
                passenger.setDoing(passenger.getDoing() - 1);
            }else{
                countPassenger++;
                passenger.setEndD(time);
                passenger.setExitTime(time);
                passenger.writing();
                for (int i = 0; i < dealPassengers.size(); i++){
                    if (dealPassengers.get(i).equals(passenger)){
                        dealPassengers.remove(i);
                        break;
                    }
                }
            }
        }
    }
}
