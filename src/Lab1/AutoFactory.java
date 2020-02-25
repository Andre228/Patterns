package Lab1;

import Lab1.Interfaces.TransportFactory;
import Lab1.Interfaces.Vehicle;

/**
 * Created by Андрей on 25.02.2020.
 */
public class AutoFactory implements TransportFactory {

    public Vehicle createInstance(String mark, int arrSize) {
        return new Car(mark, arrSize);
    }
}
