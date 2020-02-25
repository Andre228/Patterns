package Lab1.Interfaces;

/**
 * Created by Андрей on 25.02.2020.
 */
public interface TransportFactory {
    Vehicle createInstance(String mark, int arrSize);
}
