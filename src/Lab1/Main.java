package Lab1;

import Lab1.Adapter.Adapter;
import Lab1.ChainOfResponsibility.Chain;
import Lab1.ChainOfResponsibility.ColumnClass;
import Lab1.ChainOfResponsibility.RowClass;
import Lab1.Command.ColumnCommandClass;
import Lab1.Command.Command;
import Lab1.Decorator.Decorator;
import Lab1.Exceptions.DuplicateModelNameException;
import Lab1.Exceptions.NoSuchModelNameException;
import Lab1.Interfaces.TransportFactory;
import Lab1.Interfaces.Vehicle;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Created by Андрей on 19.02.2020.
 */
public class Main {

    public static void main(String[] args) throws IOException, DuplicateModelNameException, CloneNotSupportedException, NoSuchModelNameException, ClassNotFoundException {

        /*----------------------------ПУНКТ 1.1-------------------------------*/
//        PropertiesWork properties = PropertiesWork.getPropertiesWork();
//        System.out.println(properties.getStringProperties(properties.getPropertyVal()));
//
//        System.out.println(properties);
//        System.out.println(properties);
//        System.out.println(properties);
//        System.out.println(properties);
//        System.out.println(properties);




        /*---------------------------------ПУНКТ 1.2----------------------------------*/
//        Car car1 = new Car("BMW", 3);
//        car1.addModel("F30", 5500000);
//        car1.addModel("X6", 6500000);
//        car1.addModel("X1", 1200000);
//        car1.addModel("i530", 3200000);
//        car1.addModel("i730", 7200000);
//        car1.addModel("i330", 1800000);

//        MotorFactory motorFactory;
//
//         TransportFactory transportFactory = new MotorFactory();
//         VehicleStaticClass.setTransportFactory(transportFactory);
//         System.out.println(transportFactory.getClass());
//
//        TransportFactory transportFactory2 = new AutoFactory();
//        VehicleStaticClass.setTransportFactory(transportFactory2);
//        System.out.println(VehicleStaticClass.createInstance("gdfg", 4).getClass());


//        for (String str:car1.getAllModelNames()) {
//            System.out.println(str);
//        }


//        try {
//            car1.updateModelName("X1", "X1");
//        } catch (DuplicateModelNameException | NoSuchModelNameException e) {
//            e.printStackTrace();
//        }
//
//        car1.deleteModel("i730",7200000);
////
//        System.out.println("-------------------------------------------------");
//
//        for (String str:car1.getAllModelNames()) {
//            System.out.println(str);
//        }


      //  Car car2 = new Car("Toyota",2);



       /*---------------------------------ПУНКТ 1.3(clone tests)----------------------------------*/

//        Motorcycle motorcycle = new Motorcycle("Yamaha",0); //TODO: Some shit for tests
//
//        motorcycle.addModel("Y500", 540000);
//        motorcycle.addModel("Y300", 340000);
//        motorcycle.addModel("B312", 270000);
//        motorcycle.addByIndex("Test", 12345, 3);
//        motorcycle.addByIndex("Test2", 77777, 4);

        //System.out.println(motorcycle); //TODO: Тест на клона
       // System.out.println(motorcycle.printList(motorcycle));




       // System.out.println(motorcycle.getModelName(motorcycle.getModelByIndex(5)));
    //   motorcycle.deleteModel("Test",12345);

//        for (String str: motorcycle.getAllModelNames()) {
//            System.out.println(str);
//        }


//        System.out.println();
//        System.out.println("!----------------Clone------------------!");
//        System.out.println();
//
//        Motorcycle motorcycleClone = motorcycle.clone();
//        motorcycle.updateModelName("Test2", "Test22");
//        //TODO: Тест на клона
//        System.out.println(motorcycle.printList(motorcycle));
//        System.out.println(motorcycleClone.printList(motorcycleClone));

//        for (String str: motorcycleClone.getAllModelNames()) {
//            System.out.println(str);
//        }








        //------------------------LAB 2-----------------
/*-----------------------------------Adapter--------------------------------------*/

//        Adapter adapter = new Adapter();
//        adapter.writeOutputStream("Google", "USSR", "Putin");
//        adapter.readOutputStream();
//        System.out.println();


/*-------------------------------Decorator----------------------------------------*/
//
//        Vehicle vehicleCar = new Car("Nissan", 2);
//        vehicleCar.addModel("Almera Classic", 320000);
//        vehicleCar.addModel("X-Trail", 920000);
//        System.out.println(vehicleCar.getClass());
//
//        Decorator decorator = VehicleStaticClass.getDecorator(vehicleCar);
//        for (String carName:decorator.getAllModelNames()) {
//            System.out.println(carName);
//        }


        //-----------------------------LAB 3------------------------------


        /*--------------------------------Chain of Responsibility 3.1-------------------------------------------*/

//        Vehicle vehicleCar = new Car("Nissan", 3);
//        vehicleCar.addModel("Almera Classic", 320000);
//        vehicleCar.addModel("X-Trail", 920000);
//        vehicleCar.addModel("Juke", 735000);
//        //vehicleCar.addModel("Teana", 1550000);
//
//        Chain chain1 = new RowClass();
//        Chain chain2 = new ColumnClass();
//
//        chain2.setNextChain(chain1);
//        chain2.writeToFile(vehicleCar);



       /*--------------------------------Command 3.2-------------------------------------------*/

//        OutputStream outputStream = new FileOutputStream("D://JavaSaves//Maga//WriteCommandOutput.txt");
//        Car carCommand = new Car("Toyota", 2);
//        carCommand.addModel("Chaiser", 1200000);
//        carCommand.addModel("Corolla", 1000000);
//        carCommand.setPrintCommand(new ColumnCommandClass());
//        carCommand.print(outputStream);

       /*--------------------------------Iterator 3.3-------------------------------------------*/

//        Car car = new Car("Toyota", 3);
//        Car.AutoIterator iterator = car.iterator();
//        car.addModel("Chaiser", 1200000);
//        car.addModel("Corolla", 1000000);
//        car.addModel("Camry", 2500000);
//
//
//        while(iterator.hasNext()) {
//            System.out.println(iterator.next().toString());
//        }

        /*--------------------------------Memento 3.4-------------------------------------------*/


        Car car = new Car("Toyota", 2);
        car.addModel("Chaiser", 1200000);
        car.addModel("Corolla", 1000000);


        Car.Memento memento = car.createMemento();
        car.setMemento(memento);

        car.addModel("Camry", 2500000);
        car.addModel("Land Cruiser", 5000000);

        for (String modelName: car.getAllModelNames()) {
            System.out.println(modelName);
        }

        System.out.println("------------------Memento----------------------");
        for (int i = 0; i < memento.getCar().getSizeModelArray(); i++) {
            System.out.println(memento.getCar().getModelByIndex(i).toString());
        }

    }
}
