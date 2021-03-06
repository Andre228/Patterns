package Lab1.Command;

import Lab1.Car;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * Created by Андрей on 05.04.2020.
 */
public class ColumnCommandClass implements Command, Serializable {

    public void writeToFile(Car car, OutputStream outputStream) throws IOException {

        if (outputStream != null) {
            for (String str: car.getAllModelNames()) {
                str += " \n";
                byte[] buffer = str.getBytes();
                outputStream.write(buffer);
            }
        } else {
            System.out.println("Поток не существует");
        }

    }
}
