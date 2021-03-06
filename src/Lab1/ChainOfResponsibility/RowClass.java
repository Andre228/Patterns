package Lab1.ChainOfResponsibility;

import Lab1.Interfaces.Vehicle;


import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Андрей on 05.04.2020.
 */
public class RowClass implements Chain {

    private Chain nextChain;

    @Override
    public void writeToFile(Vehicle vehicle) throws IOException {

        if (vehicle.getSizeModelArray() <= 3) {
            FileWriter outputStream = new FileWriter("D://JavaSaves//Maga//WriteRowOutput.txt");

            for (String str: vehicle.getAllModelNames()) {
                outputStream.write(str + " ");
            }
            outputStream.close();
        } else {
            nextChain.writeToFile(vehicle);
        }

    }

    @Override
    public void setNextChain(Chain nextChain) {
        this.nextChain = nextChain;
    }
}
