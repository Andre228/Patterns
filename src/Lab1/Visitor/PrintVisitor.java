package Lab1.Visitor;

import Lab1.Car;
import Lab1.Exceptions.NoSuchModelNameException;
import Lab1.Motorcycle;

/**
 * Created by Андрей on 07.05.2020.
 */
public class PrintVisitor implements Visitor {

    @Override
    public void visit(Car car) {
       for (int i = 0; i < car.getSizeModelArray(); i++) {
           System.out.print(car.getModelByIndex(i).getModelName() + "  " + car.getModelByIndex(i).getPrice() + "  ");
       }
    }

    @Override
    public void visit(Motorcycle motorcycle) throws NoSuchModelNameException {
        for (String motorcycleName: motorcycle.getAllModelNames()) {
            System.out.println(motorcycleName + "  " + motorcycle.getPriceModelByName(motorcycleName));
        }
    }
}
