import controller.PassengerController;
import controller.TimeController;
import until.*;

import java.io.FileWriter;
import java.io.IOException;

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
    public static FileWriter pointCWaitingWriter;
    public static FileWriter pointCPassingWriter;
    public static FileWriter pointDWaitingWriter;
    public static FileWriter pointDPassingWriter;

    public static PointA pointA;
    public static BArea bArea;
    public static PointC pointC;
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

        pointCWaitingWriter = new FileWriter("C_Waiting.txt");
        pointCWaitingWriter.write("C Waiting Record\n");
        pointCWaitingWriter.flush();

        pointCPassingWriter = new FileWriter("C_Passing.txt");
        pointCPassingWriter.write("C Passing Record\n");
        pointCPassingWriter.flush();

        pointDWaitingWriter = new FileWriter("D_Waiting.txt");
        pointDWaitingWriter.write("D Waiting Record\n");
        pointDWaitingWriter.flush();

        pointDPassingWriter = new FileWriter("D_Passing.txt");
        pointDPassingWriter.write("D Passing Record\n");
        pointDPassingWriter.flush();

        /* points */
        pointA = new PointA(0);
        bArea = new BArea();
        PointB b1 = new PointB(1);
        PointB b2 = new PointB(2);
        PointBPre bp1 = new PointBPre(1);
        bArea.add(b1);
        bArea.add(b2);
        bArea.add(bp1);
        pointC = new PointC(2);
        pointD = new PointD(3);

        /* controller */
        timeController = new TimeController();
        passengerController = new PassengerController(passengerWriter);
    }

    public static void exit() throws IOException{
        passengerWriter.close();
        pointAWaitingWriter.close();
        pointAPassingWriter.close();
        bArea.exit();
        pointCWaitingWriter.close();
        pointCPassingWriter.close();
        pointDWaitingWriter.close();
        pointDPassingWriter.close();
    }

    public static void main(String [] args) throws IOException {
        System.out.println("Airport simulation");

        init();

        while(timeController.getTimeCounter() < 10){
            Passenger passenger = passengerController.getPassenger(timeController.getTimeCounter());
            if(passenger != null){
                pointA.add(passenger);
            }

            pointA.action();
            bArea.action();
            pointC.action();
            pointD.action();

            timeController.tick();
        }


        exit();
    }
}
