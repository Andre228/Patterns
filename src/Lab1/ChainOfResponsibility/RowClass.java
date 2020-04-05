package Lab1.ChainOfResponsibility;

import Lab1.Interfaces.Vehicle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Андрей on 05.04.2020.
 */
public class RowClass implements Chain {

    private Chain nextChain;

    @Override
    public void writeToFile(Vehicle vehicle) throws IOException {

        if (vehicle.getSizeModelArray() <= 3) {
            OutputStream outputStream = new FileOutputStream("D://JavaSaves//Maga//WriteRowOutput.txt");

            for (String str: vehicle.getAllModelNames()) {
                str += " ";
                byte[] buffer = str.getBytes();
                outputStream.write(buffer);
            }
        } else {
            nextChain.writeToFile(vehicle);
        }

    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }
}
