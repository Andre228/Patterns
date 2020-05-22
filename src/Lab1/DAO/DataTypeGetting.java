package Lab1.DAO;

import Lab1.Interfaces.Vehicle;

import java.io.IOException;

/**
 * Created by Андрей on 21.05.2020.
 */
public interface DataTypeGetting {
    void set(Vehicle vehicle);
    void get() throws IOException;
    void print();
}
