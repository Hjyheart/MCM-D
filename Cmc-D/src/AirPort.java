import controller.PassengerController;
import controller.TimeController;
import until.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hongjiayong on 2017/1/20.
 */
public class AirPort {
    /* define for passenger's state */
    public static Integer GO = 0;
    public static Integer WAITINGINA = 1;
    public static Integer WAINTINGINB = 2;
    public static Integer WAINTINGINC = 3;
    public static Integer WAINTINGIND = 4;

    public static FileWriter passengerWriter;
    public static FileWriter pointAWaitingWriter;
    public static FileWriter pointAPassingWriter;
    public static FileWriter pointDWaitingWriter;
    public static FileWriter pointDPassingWriter;

    public static PointA pointA;
    public static BArea bArea;
    public static CArea cArea;
    public static PointD pointD;

    public static TimeController timeController;
    public static PassengerController passengerController;


    public static void init() throws IOException {
        /* file writer */
        passengerWriter = new FileWriter("passenger.txt");
        passengerWriter.write("until.Passenger Record\n");
        passengerWriter.write("id | arrive time | exit time | stop at A | stop at B | stop at C | stop at D |\n");
        passengerWriter.flush();

        pointAWaitingWriter = new FileWriter("A_Waiting.txt");
        pointAWaitingWriter.write("A Waiting Record\n");
        pointAWaitingWriter.flush();

        pointAPassingWriter = new FileWriter("A_Passing.txt");
        pointAPassingWriter.write("A Passing Record");
        pointAPassingWriter.flush();

        pointDWaitingWriter = new FileWriter("D_Waiting.txt");
        pointDWaitingWriter.write("D Waiting Record\n");
        pointDWaitingWriter.flush();

        pointDPassingWriter = new FileWriter("D_Passing.txt");
        pointDPassingWriter.write("D Passing Record\n");
        pointDPassingWriter.flush();

        /* points */
        pointD = new PointD(3, pointDWaitingWriter, pointDPassingWriter);
        cArea = new CArea();
        PointC c1 = new PointC(1);
        PointC c2 = new PointC(2);
        PointC c3 = new PointC(3);
        cArea.add(c1);
        cArea.add(c2);
        cArea.add(c3);
        bArea = new BArea();
        PointB b1 = new PointB(1, cArea, pointD);
        PointB b2 = new PointB(2, cArea, pointD);
        PointB b3 = new PointB(3, cArea, pointD);
        PointBPre bp1 = new PointBPre(1, cArea, pointD);
        bArea.add(b1);
        bArea.add(b2);
        bArea.add(b3);
        bArea.add(bp1);
        pointA = new PointA(0, bArea, pointAWaitingWriter, pointAPassingWriter);

        /* controller */
        timeController = new TimeController();
        passengerController = new PassengerController(passengerWriter);
    }

    public static void exit() throws IOException{
        passengerWriter.close();
        pointAWaitingWriter.close();
        pointAPassingWriter.close();
        bArea.exit();
        pointDWaitingWriter.close();
        pointDPassingWriter.close();
    }

    public static void main(String [] args) throws IOException {
        System.out.println("Airport simulation");

        init();

        while(timeController.getTimeCounter() < 3600 * 100){
            ArrayList<Passenger> passengers = passengerController.getPassenger(timeController.getTimeCounter());
            if(passengers.size() != 0){
                for (Passenger passenger : passengers){
                    passenger.setStartA(timeController.getTimeCounter());
                    pointA.add(passenger);
                }
            }
            if (timeController.getTimeCounter() % 60 == 0){
                pointA.action(true, timeController.getTimeCounter());
                bArea.action(true, timeController.getTimeCounter());
                cArea.action(true, timeController.getTimeCounter());
                pointD.action(true, timeController.getTimeCounter());
            }else{
                pointA.action(false, timeController.getTimeCounter());
                bArea.action(false, timeController.getTimeCounter());
                cArea.action(false, timeController.getTimeCounter());
                pointD.action(false, timeController.getTimeCounter());
            }

            timeController.tick();
        }


        exit();
    }
}
