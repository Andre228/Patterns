package Lab1.DAO;

import Lab1.Interfaces.Vehicle;

import java.io.*;

/**
 * Created by Андрей on 21.05.2020.
 */
public class Text implements DataTypeGetting {

    private Vehicle vehicle;

    private String mark;
    private int count ;
    private double[] prices ;
    private String[] models ;

    @Override
    public void set(Vehicle vehicle) {
        this.vehicle = vehicle;
        try {
            FileWriter writer = new FileWriter("src/Lab1/DAO/text.txt");
            writer.write("" + vehicle.getMark());
            writer.write("\n" + vehicle.getSizeModelArray());
            for (int i = 0; i < vehicle.getSizeModelArray(); i++) {
                writer.write("\n" +  vehicle.getAllModelNames()[i]);
                writer.write("\n" +  vehicle.getAllModelPrices()[i]);
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка записи в файл " + e);
        }
    }

    @Override
    public void get() throws IOException {
        try{
            FileReader fileReader = new FileReader("src/Lab1/DAO/text.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            mark = bufferedReader.readLine();
            count = Integer.valueOf(bufferedReader.readLine());
            models = new String[count];
            prices = new double[count];
            for(int i = 0; i < count; i++){
                models[i] = bufferedReader.readLine();
                prices[i] = Double.valueOf(bufferedReader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка прочтения файла " + e);
        }
    }

    @Override
    public void print() {
        System.out.println("Вывод информации о машине...");
        System.out.println("--------------------------------");
        System.out.println("Марка: " + mark + "  Количество моделей: " + count);
        for (int i = 0; i <  count; i++) {
            System.out.println("       " + models[i] + "  " + prices[i]);
        }
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
