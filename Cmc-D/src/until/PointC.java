package until;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hongjiayong on 2017/1/20.
 */
public class PointC extends Point {
    private FileWriter fileWriterWaiting;
    private FileWriter fileWriterPassing;
    private Passenger passenger;
    private Integer countPassenger;
    public PointC(Integer name) throws IOException {
        super(name);

        fileWriterWaiting = new FileWriter(String.valueOf(name) + "_C_Waiting.txt");
        fileWriterWaiting.write("C " + String.valueOf(name) + " Waiting Record\n");
        fileWriterWaiting.flush();

        fileWriterPassing = new FileWriter(String.valueOf(name) + "_C_Passing.txt");
        fileWriterPassing.write("C " + String.valueOf(name) + " Passing Record\n");
        fileWriterPassing.flush();
    }

    @Override
    public void action(Boolean flag, Integer time) throws IOException {
        if (passenger == null && getWaitingList().size() != 0){
            passenger = getWaitingList().poll();
            // TODO:对时间取一个范围随机数
            passenger.setDoing(10);
        }

        if (passenger != null){
            if (passenger.getDoing() > 0){
                passenger.setDoing(passenger.getDoing() - 1);
            }else{
                countPassenger++;
                passenger.setEndC(time);
                passenger.setExitTime(time);
                passenger.writing();
                passenger = null;
            }
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

    public void exit() throws IOException {
        fileWriterPassing.close();
        fileWriterWaiting.close();
    }
}
