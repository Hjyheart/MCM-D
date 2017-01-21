package until;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hongjiayong on 2017/1/21.
 */
public class CArea {
    private ArrayList<PointC> cs;

    public CArea(){
        cs = new ArrayList<>();
    }

    public ArrayList<PointC> getCs() {
        return cs;
    }

    public void setCs(ArrayList<PointC> cs) {
        this.cs = cs;
    }

    public void add(PointC pointC){
        cs.add(pointC);
    }

    public void action(Boolean flag, Integer time) throws IOException {
        for (PointC pointC : cs){
            pointC.action(flag, time);
        }
    }

    public void exit() throws IOException{
        for (PointC pointC : cs){
            pointC.exit();
        }
    }
}
