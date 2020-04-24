package Lab1;

import Lab1.Command.Command;
import Lab1.Command.RowCommadClass;
import Lab1.Exceptions.DuplicateModelNameException;
import Lab1.Exceptions.ModelPriceOutOfBoundsException;
import Lab1.Exceptions.NoSuchModelNameException;
import Lab1.Interfaces.Vehicle;

import java.io.*;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Created by Андрей on 19.02.2020.
 */
public class Car implements Vehicle, Cloneable, Serializable {

    private String mark;
    private Model[] arrayModel;
    private Command command = new RowCommadClass();
    private AutoIterator autoIterator;


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
            if(arrayModel[i].modelName.equals(modelName)) {
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
                if (arrayModel[i].modelName.equals(modelName))
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
                    if (arrayModel[i].modelName.equals(modelName) && arrayModel[i].price == price) {
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

    public void deleteByIndex(int i) {
        Model[] copy = new Model[arrayModel.length - 1];
        System.arraycopy(arrayModel, 0, copy, 0, i);
        System.arraycopy(arrayModel, i + 1, copy, i, arrayModel.length - i - 1);
        arrayModel = copy;
    }

    public int getSizeModelArray() {
        return arrayModel.length;
    }

    public Model getModelByIndex(int i) {
        return arrayModel[i];
    }

    public int getIndexByName(String modelName) {
        if(arrayModel[arrayModel.length - 1] != null) {
            return Arrays.asList(getAllModelNames()).indexOf(modelName);
        } else {
            return -1;
        }
    }

    public void setPrintCommand(Command command) {
        this.command = command;
    }

    public void print(OutputStream outputStream) throws IOException {
        if (this.command != null) {
            command.writeToFile(this, outputStream);
        } else {
            System.out.println("Команда не задана");
        }
    }

    @Override
    public Car clone() throws CloneNotSupportedException {
        Car clone = (Car) super.clone();
        clone.arrayModel = this.arrayModel.clone();
        for (int i = 0; i < arrayModel.length; i++) {
            clone.arrayModel[i] = this.arrayModel[i].clone();
        }
        return clone;
    }

    public AutoIterator iterator() {
        if (this.autoIterator != null) return this.autoIterator;
        else  return new AutoIterator();
    }

    public Memento createMemento() throws IOException, ClassNotFoundException {
        return new Memento(this);
    }

    public void setMemento(Memento memento) throws IOException, ClassNotFoundException {
        memento.setAuto();
    }


    public static class Model implements Serializable {
        private String modelName;
        private double price;

        public Model() {}

        public Model(String modelName, double price) {
            this.modelName = modelName;
            this.price = price;
        }


        @Override
        protected Model clone() throws CloneNotSupportedException {
            return (Model) super.clone();
        }

        public String toString() {
            return modelName + "  " + price;
        }


    }

    protected class AutoIterator implements java.util.Iterator {

        int index;

        @Override
        public boolean hasNext() {
            return index < getSizeModelArray();
        }

        @Override
        public Model next() {
            return arrayModel[index++];
        }

        @Override
        public void remove() {
            deleteByIndex(index);
        }
    }

    public static class Memento implements Serializable {

        private ByteArrayOutputStream state = new ByteArrayOutputStream(64);
        private Car car = new Car();


        public Memento(Car car) throws IOException, ClassNotFoundException {
            this.car = car;
            setAuto();
        }

        public void setAuto() throws IOException, ClassNotFoundException {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(state);
            objectOutputStream.writeObject(car);



            state.close();
            objectOutputStream.close();


//            if (this.mark != null && this.arrayModel != null) {
//                this.state.write((this.mark + ":\n").getBytes());
//                for (Model model:this.arrayModel) {
//                    String price = String.valueOf(model.price) + "\n";
//                    this.state.write((" " + model.modelName + "  ").getBytes());
//                    this.state.write(price.getBytes());
//                }
//                this.state.close();
//            }
        }

        public ByteArrayOutputStream getAuto() {
            return this.state;
        }

        public Car getCar() throws IOException, ClassNotFoundException {
            byte[] buffer = state.toByteArray();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            byteArrayInputStream.close();
            objectInputStream.close();
            return (Car)objectInputStream.readObject();
        }
    }
}
