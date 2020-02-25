package Lab1.Interfaces;

import Lab1.Exceptions.DuplicateModelNameException;
import Lab1.Exceptions.NoSuchModelNameException;

/**
 * Created by Андрей on 25.02.2020.
 */
public interface Vehicle {

    String getMark();
    void updateMark(String mark);
    void updateModelName(String oldName, String newName) throws DuplicateModelNameException, NoSuchModelNameException;
    String[] getAllModelNames();
    double getPriceModelByName(String modelName) throws NoSuchModelNameException;
    void updatePriceModelByName(String modelName, double price) throws NoSuchModelNameException;
    double[] getAllModelPrices();
    void addModel(String modelName, double price) throws DuplicateModelNameException;
    void deleteModel(String modelName, double price) throws NoSuchModelNameException;
    int getSizeModelArray();

}
