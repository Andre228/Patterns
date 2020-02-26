package Lab1;

import Lab1.Exceptions.DuplicateModelNameException;
import Lab1.Exceptions.ModelPriceOutOfBoundsException;
import Lab1.Exceptions.NoSuchModelNameException;
import Lab1.Interfaces.Vehicle;

import java.util.Arrays;

/**
 * Created by Андрей on 19.02.2020.
 */
public class Motorcycle implements Vehicle, Cloneable {



    private class Model implements Cloneable {
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

        @Override
        public Model clone() throws CloneNotSupportedException {
            return (Model) super.clone();
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

    public void updateModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException {
       if (getModelByName(oldName) != null) {
           if(getModelByName(newName) == null) getModelByName(oldName).modelName = newName;
           else throw new DuplicateModelNameException(newName);
       }
       else {
           throw new NoSuchModelNameException(oldName);
       }

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

    public double getPriceModelByName(String modelName) throws NoSuchModelNameException {
        double founded = 0;
        if (getModelByName(modelName) != null) {
            for (int i = 0; i < size; i++) {
                if (getModelByIndex(i).getModelName() == modelName) founded = getModelByIndex(i).price;
            }
            return founded;
        }
        else {
            throw new NoSuchModelNameException(modelName);
        }

    }

    public void updatePriceModelByName(String modelName, double price) throws NoSuchModelNameException {
        if (0 < price && price < Double.MAX_VALUE) {
            if (getModelByName(modelName) != null) {
                getModelByName(modelName).price = price;
            } else {
                throw new NoSuchModelNameException(modelName);
            }
        } else {
            throw new ModelPriceOutOfBoundsException();
        }
    }

    public double[] getAllModelPrices() {

        double [] modelPricesArr = new double[]{};
        for (int i=0; i<size; i++)
            modelPricesArr[i] = getModelByIndex(i).getPrice();

        return modelPricesArr;

    }

    public void addModel(String modelName, double price) throws DuplicateModelNameException {
        if (0 < price && price < Double.MAX_VALUE) {
            if (getModelByName(modelName) == null) {
                Model model = new Model(modelName, price);
                model.next = head;
                model.prev = head.prev;
                model.prev.next = model;
                model.next.prev = model;
                size++;
            }
            else {
                throw new DuplicateModelNameException(modelName);
            }
        }
        else {
            throw new ModelPriceOutOfBoundsException();
        }

    }

    public void addByIndex(String modelName, double price, int index) throws DuplicateModelNameException {

        if (getModelByName(modelName) == null) {
            if (0 < price && price < Double.MAX_VALUE) {
                Model model = new Model(modelName, price);

                Model m = getModelByIndex(index);


                m.prev.next = model;
                model.next = m;
                model.prev = m.prev;
                m.prev = model;

                model = m;

                size++;
            }
            else {
                throw new ModelPriceOutOfBoundsException();
            }
        }
        else {
            throw new DuplicateModelNameException(modelName);
        }


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

    public Model getModelByName(String name) {

        Model model = head.next;
        while (model != head) {
            if (model.getModelName() == name) {
                return model;
            }
            model = model.next;
        }
        return null;
    }

    public void deleteModel(String modelName, double price) throws NoSuchModelNameException {

        if (getModelByName(modelName) != null) {
            Model m;
            m = head;
            for (int i = 0; i < size; i++) {
                if (getModelByIndex(i).getModelName() == modelName && getModelByIndex(i).getPrice() == price) {
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
        else {
            throw new NoSuchModelNameException(modelName);
        }

    }

    public String printList(Motorcycle motorcycle) {

        String listForPrinting = "";
        for (int i = 0; i <= motorcycle.size; i++) {
            listForPrinting += "| " + getModelByIndex(i).modelName  + " | " + "--> ";
        }


        return listForPrinting;
    }

    public int getSizeModelArray() {
        return size;
    }

    @Override
    public Motorcycle clone() throws CloneNotSupportedException {
        Motorcycle clone = (Motorcycle) super.clone();

        Model cloneModel = head.clone();
        for (int i = 1; i < size; i++) {
            Model _cloneTmp = getModelByIndex(i).clone();

            cloneModel.next = _cloneTmp;
            _cloneTmp.next = cloneModel.next.next;
            _cloneTmp.prev = cloneModel;
            cloneModel.prev = _cloneTmp;

            cloneModel = _cloneTmp;

        }


        return clone;

    }


}
