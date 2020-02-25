package Lab1.Exceptions;

/**
 * Created by Андрей on 25.02.2020.
 */
public class ModelPriceOutOfBoundsException extends RuntimeException {

    public ModelPriceOutOfBoundsException() {
        super("Неверная цена");
    }
}
