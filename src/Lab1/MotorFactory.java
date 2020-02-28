package Lab1;

import Lab1.Interfaces.TransportFactory;
import Lab1.Interfaces.Vehicle;

/**
 * Created by Fedot on 28.02.2020.
 */
public class MotorFactory implements TransportFactory {

    public Vehicle createInstance(String mark, int arrSize) {
        return new Motorcycle(mark, arrSize);
    }
}
