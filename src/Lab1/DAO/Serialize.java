package Lab1.DAO;

import Lab1.Interfaces.Vehicle;

import java.io.*;

/**
 * Created by Андрей on 21.05.2020.
 */
public class Serialize implements DataTypeGetting {

    private Vehicle vehicle;

    public Serialize() {}


    @Override
    public void set(Vehicle vehicle){
        try {
            this.vehicle = vehicle;
            FileOutputStream fileOutputStream = new FileOutputStream
                    ("src/Lab1/DAO/serialize.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(vehicle);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка записи в файл " + e);
        }
    }

    @Override
    public void get() throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/Lab1/DAO/serialize.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            vehicle = (Vehicle) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ошибка прочтения файла " + e);
        }
    }

    @Override
    public void print() {
        System.out.println("Вывод информации о машине...");
        String mark = vehicle.getMark();
        double[] prices = vehicle.getAllModelPrices();
        String[] models = vehicle.getAllModelNames();
        System.out.println("--------------------------------");
        System.out.println("Марка: " + mark + "  Количество моделей: " + vehicle.getSizeModelArray());
        for (int i = 0; i <  vehicle.getSizeModelArray(); i++) {
            System.out.println("       " + models[i] + "  " + prices[i]);
        }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
