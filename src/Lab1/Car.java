package Lab1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Андрей on 19.02.2020.
 */
public class Car {

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

    public void updateModelName(Model model, String modelName) {
        model.modelName = modelName;
    }

    public String[] getAllModelNames() {

        String [] modelNamesArr = new String[arrayModel.length];
        for (int i=0; i<arrayModel.length; i++)
            modelNamesArr[i] = arrayModel[i].modelName;

        return modelNamesArr;
    }

    public double getPriceModelByName(String modelName) {

        double founded = 0;
        for(int i=0; i<arrayModel.length; i++) {
            if(arrayModel[i].modelName == modelName) founded = arrayModel[i].price;
        }

        return founded;
    }

    public void updatePriceModelByName(String modelName, double price) {

        for(int i=0; i<arrayModel.length; i++) {
            if(arrayModel[i].modelName == modelName) arrayModel[i].price = price;
        }

    }

    public double[] getAllModelPrices() {

        double [] modelPricesArr = new double[]{};
        for (int i=0; i<arrayModel.length; i++)
            modelPricesArr[i] = arrayModel[i].price;

        return modelPricesArr;
    }

    public void addModel(String modelName, double price) {

//
//        if(arrayModel[0] == null) {
//            arrayModel[0] = new Model(modelName, price);
//        }
//        else {
//            arrayModel = Arrays.copyOf(arrayModel, length);
//            System.out.println(length);
//            arrayModel[length] = new Model(modelName, price);
//
//        }
        int length = arrayModel.length;
        if(arrayModel[length-1] == null)
            for(int i=0; i<length; i++) {
                if(arrayModel[i] == null) {
                    arrayModel[i] = new Model(modelName, price);
                    break;
                }

            }
            else {
            length = length + 1;
            arrayModel = Arrays.copyOf(arrayModel, length);
            arrayModel[length-1] = new Model(modelName, price);
        }


    }

    public void deleteModel(String modelName, double price) {
        if(arrayModel.length != 0) {
            for (int i=0; i<arrayModel.length; i++) {
                if(arrayModel[i].modelName == modelName && arrayModel[i].price == price) {
                    Model[] copy = new Model[arrayModel.length-1];
                    System.arraycopy(arrayModel, 0, copy, 0, i);
                    System.arraycopy(arrayModel, i+1, copy, i, arrayModel.length-i-1);
                    arrayModel = copy;
                }
            }
        }
    }

    public int getSizeModelArray() {
        return arrayModel.length;
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
