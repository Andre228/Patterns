package Lab1.Visitor;

import Lab1.Car;
import Lab1.Exceptions.NoSuchModelNameException;
import Lab1.Motorcycle;

/**
 * Created by Андрей on 07.05.2020.
 */
public interface Visitor {
    void visit(Car car);
    void visit(Motorcycle car) throws NoSuchModelNameException;
}
