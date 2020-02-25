package Lab1;

import Lab1.Exceptions.DuplicateModelNameException;
import Lab1.Exceptions.ModelPriceOutOfBoundsException;
import Lab1.Exceptions.NoSuchModelNameException;
import Lab1.Interfaces.Vehicle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Андрей on 19.02.2020.
 */
public class Car implements Vehicle {

    private String mark;
    private Model[] arrayModel;


    public Car() {}

    public Car(String mark, int arrSize) {
        this.mark = mark;
        this.arrayModel = new Model[arrSize];
    }


    public String getMark() {
        return mark;
    }

    public void updateMark(String mark) {
        this.mark = mark;
    }

    public boolean hasModelByName(String modelName) {
        return Arrays.asList(getAllModelNames()).contains(modelName);
    }

    public void updateModelName(String oldName, String modelName) throws DuplicateModelNameException, NoSuchModelNameException {

        int index = getIndexByName(oldName);

        if (hasModelByName(modelName)) throw new DuplicateModelNameException(modelName);
        else {
            if (index != -1) arrayModel[index].modelName = modelName;
            else {
                throw new NoSuchModelNameException(oldName);
            }
        }

    }

    public String[] getAllModelNames() {

        String [] modelNamesArr = new String[arrayModel.length];
        for (int i=0; i<arrayModel.length; i++)
            modelNamesArr[i] = arrayModel[i].modelName;

        return modelNamesArr;
    }

    public double getPriceModelByName(String modelName) throws NoSuchModelNameException {

        double founded = 0;
        for(int i=0; i<arrayModel.length; i++) {
            if(arrayModel[i].modelName == modelName) {
                founded = arrayModel[i].price;
            }
            else {
                throw new NoSuchModelNameException(modelName);
            }
        }

        return founded;
    }

    public void updatePriceModelByName(String modelName, double price) throws NoSuchModelNameException {

        int index = getIndexByName(modelName);
        if(index != -1) {
            for (int i = 0; i < arrayModel.length; i++) {
                if (arrayModel[i].modelName == modelName)
                    if (0 < price && price < Double.MAX_VALUE) arrayModel[i].price = price;
                else {
                    throw new ModelPriceOutOfBoundsException();
                }
            }
        }
        else {
            throw new NoSuchModelNameException(modelName);
        }

    }

    public double[] getAllModelPrices() {

        double [] modelPricesArr = new double[]{};
        for (int i=0; i<arrayModel.length; i++)
            modelPricesArr[i] = arrayModel[i].price;

        return modelPricesArr;
    }

    public void addModel(String modelName, double price) throws DuplicateModelNameException {
        int index = getIndexByName(modelName);
        if (0 < price && price <= Double.MAX_VALUE) {
            if (index == -1) {
                int length = arrayModel.length;
                if (arrayModel[length - 1] == null)
                    for (int i = 0; i < length; i++) {
                        if (arrayModel[i] == null) {
                            arrayModel[i] = new Model(modelName, price);
                            break;
                        }
                    }
                else {
                    length = length + 1;
                    arrayModel = Arrays.copyOf(arrayModel, length);
                    arrayModel[length - 1] = new Model(modelName, price);
                }
            }
            else {
                throw new DuplicateModelNameException(modelName);
            }
        }
        else {
            throw new ModelPriceOutOfBoundsException();
        }
    }

    public void deleteModel(String modelName, double price) throws NoSuchModelNameException {
        if (getIndexByName(modelName) != -1) {
            if (arrayModel.length != 0) {
                for (int i = 0; i < arrayModel.length; i++) {
                    if (arrayModel[i].modelName == modelName && arrayModel[i].price == price) {
                        Model[] copy = new Model[arrayModel.length - 1];
                        System.arraycopy(arrayModel, 0, copy, 0, i);
                        System.arraycopy(arrayModel, i + 1, copy, i, arrayModel.length - i - 1);
                        arrayModel = copy;
                    }
                }
            }
        }
        else {
            throw new NoSuchModelNameException(modelName);
        }
    }

    public int getSizeModelArray() {
        return arrayModel.length;
    }

    public int getIndexByName(String modelName) {
      return Arrays.asList(getAllModelNames()).indexOf(modelName);
    }


    private class Model {
        private String modelName;
        private double price;

        public Model() {}

        public Model(String modelName, double price) {
            this.modelName = modelName;
            this.price = price;
        }


    }
}
