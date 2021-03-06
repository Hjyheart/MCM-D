package until;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hongjiayong on 2017/1/21.
 */
public class PointBPre extends Point {
    private FileWriter fileWriterWaiting;
    private FileWriter fileWriterPassing;
    private Passenger passenger;
    private CArea next1;
    private PointD next2;
    private Integer countPassenger;

    public PointBPre(Integer name, CArea cArea, PointD pointD) throws IOException {
        super(name);

        next1 = cArea;
        next2 = pointD;
        countPassenger = 0;

        fileWriterWaiting = new FileWriter(String.valueOf(name) + "_B_Pre_Waiting.txt");
        fileWriterWaiting.write("B " + String.valueOf(name) + " Pre Waiting Record\n");
        fileWriterWaiting.flush();

        fileWriterPassing = new FileWriter(String.valueOf(name) + "_B_Pre_Passing.txt");
        fileWriterPassing.write("B " + String.valueOf(name) + " Pre Passing Record\n");
        fileWriterPassing.flush();
    }

    @Override
    public void action(Boolean flag, Integer time){
        if (passenger == null && getWaitingList().size() != 0){
            passenger = getWaitingList().poll();
            passenger.setDoing(getTime());
        }

        if (passenger != null){
            if (passenger.getDoing() > 0){
                passenger.setDoing(passenger.getDoing() - 1);
            }else{
                countPassenger++;
                passenger.setEndB(time);

                if (Math.random() * 100 < 2){
                    // to d
                    passenger.setStartD(time);
                    next2.add(passenger);
                }else {
                    // to c
                    passenger.setStartC(time);
                    if (!passenger.getPre()) {
                        next1.getCs().get(gotoC(18)).add(passenger);
                    }else{
                        next1.getCbs().get(gotoC(6)).add(passenger);
                    }
                }
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

    public Integer getTime(){
        Integer num1 = (int) Math.round(Math.random() * 5 + 12);
        Integer num2 = (int) Math.round(Math.random() * 5 + 34);

        if (Math.random() > 0.1){
//            return num1 * 4 / 5;
            return num1;
        }else {
//            return num2 * 4 / 5;
            return num2;
        }
    }

    public Integer gotoC(int n){
        Integer num = (int) (Math.random() * n);
        return num;
    }

}
