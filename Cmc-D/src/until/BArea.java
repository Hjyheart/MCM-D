package until;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hongjiayong on 2017/1/20.
 */
public class BArea {
    private ArrayList<PointB> bs;
    private ArrayList<PointBPre> bsPre;

    public BArea(){
        bs = new ArrayList<>();
        bsPre = new ArrayList<>();
    }

    public ArrayList<PointB> getBs() {
        return bs;
    }

    public void setBs(ArrayList<PointB> bs) {
        this.bs = bs;
    }

    public void add(PointB pointB){
        bs.add(pointB);
    }

    public void add(PointBPre pointBPre){
        bsPre.add(pointBPre);
    }

    public void action(){

    }

    public void exit() throws IOException {
        for (PointB pointB : bs){
            pointB.exit();
        }

        for (PointBPre pointBPre : bsPre){
            pointBPre.exit();
        }
    }
}
