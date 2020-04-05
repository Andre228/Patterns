package Lab1.Command;

import Lab1.Car;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Андрей on 05.04.2020.
 */
public interface Command {
     void writeToFile(Car car, OutputStream outputStream) throws IOException;
}
