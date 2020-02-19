package Lab1;

import java.util.Arrays;

/**
 * Created by Андрей on 19.02.2020.
 */
public class Motorcycle {



    private class Model {
        private String modelName;
        private double price;

        Model prev = null;
        Model next = null;

        public Model() {}

        public Model(String modelName, double price) {
            this.modelName = modelName;
            this.price = price;
        }

        public String getModelName() {
            return modelName;
        }

        public double getPrice() {
            return price;
        }


    }

    private Model head = new Model();
    {
        head.prev = head;
        head.next = head;
    }

    private int size = 0;


    private String mark;
    //private Model arrayModel;


    public Motorcycle() {}

    public Motorcycle(String mark, int size) {
        this.mark = mark;
        this.size = size;
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

        Model m = head;

        String [] modelNamesArr = new String[size];
        for (int i=0; i<size; i++) {
            modelNamesArr[i] = m.next.getModelName();
            m = m.next;
        }


        return modelNamesArr;

    }

    public double getPriceModelByName(String modelName) {
        double founded = 0;
        for(int i=0; i<size; i++) {
            if(getModelByIndex(i).getModelName() == modelName) founded = getModelByIndex(i).price;
        }

        return founded;

    }

    public void updatePriceModelByName(String modelName, double price) {

    }

    public double[] getAllModelPrices() {

        double [] modelPricesArr = new double[]{};
        for (int i=0; i<size; i++)
            modelPricesArr[i] = getModelByIndex(i).getPrice();

        return modelPricesArr;

    }

    public void addModel(String modelName, double price) {

        Model model = new Model(modelName,price);
        model.next = head;
        model.prev = head.prev;
        model.prev.next = model;
        model.next.prev = model;
        size++;

    }

    public void addByIndex(String modelName, double price, int index) {

        Model model = new Model(modelName,price);

        Model m = getModelByIndex(index);


        m.prev.next = model;
        model.next = m;
        model.prev = m.prev;
        m.prev = model;

        model = m;

        size++;


    }

    public String getModelName(Model model) {
        return model.getModelName();
    }

    public Model getModelByIndex(int index) {

        Model m;
        m = head;
        int i = 1;
        while (i <= index) {
            m = m.next;
            ++i;
        }

        return m;
    }

    public void deleteModel(String modelName, double price) {

        Model m;
        m = head;
        for(int i=0; i<size; i++) {
            if(getModelByIndex(i).getModelName() == modelName && getModelByIndex(i).getPrice() == price){
                m = getModelByIndex(i);
                break;
            }
        }
        m.prev.next = m.next;
        m.next.prev = m.prev;
        m.next = m.prev = null;
        m = null;
        size--;

    }

    public int getSizeModelArray() {
        return size;
    }


}
