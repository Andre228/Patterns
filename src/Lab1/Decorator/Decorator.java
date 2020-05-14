package Lab1.Decorator;

import Lab1.Exceptions.DuplicateModelNameException;
import Lab1.Exceptions.NoSuchModelNameException;
import Lab1.Interfaces.Vehicle;
import Lab1.Visitor.Visitor;

/**
 * Created by Андрей on 04.03.2020.
 */
public class Decorator implements Vehicle {

    private Vehicle vehicle;

    public Decorator(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public synchronized String getMark() {
        return vehicle.getMark();
    }

    @Override
    public synchronized void updateMark(String mark) {
        vehicle.updateMark(mark);
    }

    @Override
    public synchronized void updateModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException {
        vehicle.updateModelName(oldName, newName);
    }

    @Override
    public synchronized String[] getAllModelNames() {
        return vehicle.getAllModelNames();
    }

    @Override
    public synchronized double getPriceModelByName(String modelName) throws NoSuchModelNameException {
        return vehicle.getPriceModelByName(modelName);
    }

    @Override
    public synchronized void updatePriceModelByName(String modelName, double price) throws NoSuchModelNameException {
        vehicle.updatePriceModelByName(modelName, price);
    }

    @Override
    public synchronized double[] getAllModelPrices() {
        return vehicle.getAllModelPrices();
    }

    @Override
    public synchronized void addModel(String modelName, double price) throws DuplicateModelNameException {
        vehicle.addModel(modelName, price);
    }

    @Override
    public synchronized void deleteModel(String modelName, double price) throws NoSuchModelNameException {
        vehicle.deleteModel(modelName, price);
    }

    @Override
    public synchronized int getSizeModelArray() {
        return vehicle.getSizeModelArray();
    }

    @Override
    public void accept(Visitor visitor) throws NoSuchModelNameException {

    }
}
