package Lab1;

import java.io.IOException;

/**
 * Created by Андрей on 19.02.2020.
 */
public class Main {

    public static void main(String[] args) throws IOException {
/*----------------------------ПУНКТ 1.1-------------------------------*/
//        PropertiesWork properties = PropertiesWork.getPropertiesWork();
//        System.out.println(properties.getStringProperties(properties.getPropertyVal()));

//        System.out.println(properties);
//        System.out.println(properties);
//        System.out.println(properties);
//        System.out.println(properties);
//        System.out.println(properties);




        /*---------------------------------ПУНКТ 1.2----------------------------------*/
        Car car1 = new Car("BMW", 3);
        car1.addModel("F30", 5500000);
        car1.addModel("X6", 6500000);
        car1.addModel("X1", 1200000);
        car1.addModel("i530", 3200000);
        car1.addModel("i730", 7200000);
        car1.addModel("i330", 1800000);

        for (String str:car1.getAllModelNames()) {
            System.out.println(str);
        }

        car1.deleteModel("i730",7200000);

        System.out.println("-------------------------------------------------");

        for (String str:car1.getAllModelNames()) {
            System.out.println(str);
        }


      //  Car car2 = new Car("Toyota",2);


    }
}
