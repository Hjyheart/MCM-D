package until;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by hongjiayong on 2017/1/21.
 */
public class CArea {
    private ArrayList<PointC> cs;
    private ArrayList<PointCPre> cbs;

    public CArea(){
        cs = new ArrayList<>();
        cbs = new ArrayList<>();
    }

    public ArrayList<PointC> getCs() {
        return cs;
    }

    public ArrayList<PointCPre> getCbs() {
        return cbs;
    }

    public void setCbs(ArrayList<PointCPre> cbs) {
        this.cbs = cbs;
    }

    public void setCs(ArrayList<PointC> cs) {
        this.cs = cs;
    }

    public void add(PointC pointC){
        cs.add(pointC);
    }

    public void add(PointCPre pointCPre){
        cbs.add(pointCPre);
    }

    public void action(Boolean flag, Integer time) throws IOException {
        for (PointC pointC : cs){
            pointC.action(flag, time);
        }

        for (PointCPre pointCPre : cbs){
            pointCPre.action(flag, time);
        }
    }

    public void exit() throws IOException{
        for (PointC pointC : cs){
            pointC.exit();
        }

        for (PointCPre pointCPre : cbs){
            pointCPre.exit();
        }
    }
}
