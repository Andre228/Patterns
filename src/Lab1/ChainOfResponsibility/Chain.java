package Lab1.ChainOfResponsibility;

import Lab1.Interfaces.Vehicle;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Андрей on 05.04.2020.
 */
public interface Chain {
    void writeToFile(Vehicle vehicle) throws IOException;
    void setNextChain(Chain nextChain);
}
