package Lab1;

import Lab1.Interfaces.TransportFactory;
import Lab1.Interfaces.Vehicle;

/**
 * Created by Андрей on 25.02.2020.
 */
public class VehicleStaticClass {

    private static TransportFactory factory = new AutoFactory();

    public static double averagePrice(Vehicle vehicle) {
        double result = 0;
        for (double price : vehicle.getAllModelPrices()) {
            result += price;
        }
        return result / vehicle.getAllModelPrices().length;
    }

    public static void printModels(Vehicle vehicle) {
        for (String str: vehicle.getAllModelNames()) {
            System.out.println(str);
        }
    }

    public static void printPrices(Vehicle vehicle) {
        for (Double price: vehicle.getAllModelPrices()) {
            System.out.println(price);
        }
    }

    public static void setTransportFactory(TransportFactory transportFactory) {
        factory = transportFactory;
    }

    public static Vehicle createInstance(String mark, int arrSize) {
        return factory.createInstance(mark, arrSize);
    }


}
