package until;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hongjiayong on 2017/1/21.
 */
public class PointBPre extends Point {
    private FileWriter fileWriterWaiting;
    private FileWriter fileWriterPassing;
    public PointBPre(Integer name) throws IOException {
        super(name);

        fileWriterWaiting = new FileWriter(String.valueOf(name) + "_B_Pre_Waiting.txt");
        fileWriterWaiting.write("B " + String.valueOf(name) + " Pre Waiting Record\n");
        fileWriterWaiting.flush();

        fileWriterPassing = new FileWriter(String.valueOf(name) + "_B_Pre_Passing.txt");
        fileWriterPassing.write("B " + String.valueOf(name) + " Pre Passing Record\n");
        fileWriterPassing.flush();
    }

    @Override
    public void action(){

    }

    public void exit() throws IOException {
        fileWriterPassing.close();
        fileWriterWaiting.close();
    }
}
