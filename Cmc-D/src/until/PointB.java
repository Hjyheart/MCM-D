package until;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by hongjiayong on 2017/1/20.
 */
public class PointB extends Point {
    private FileWriter fileWriterWaiting;
    private FileWriter fileWriterPassing;
    public PointB(Integer name) throws IOException {
        super(name);

        fileWriterWaiting = new FileWriter(String.valueOf(name) + "_B_Waiting.txt");
        fileWriterWaiting.write("B " + String.valueOf(name) + " Waiting Record\n");
        fileWriterWaiting.flush();

        fileWriterPassing = new FileWriter(String.valueOf(name) + "_B_Passing.txt");
        fileWriterPassing.write("B " + String.valueOf(name) + " Passing Record\n");
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
