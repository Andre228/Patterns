package Lab1.Exceptions;

/**
 * Created by Андрей on 25.02.2020.
 */
public class NoSuchModelNameException extends Exception {

    public NoSuchModelNameException(String name) {
        super("В массиве нет такого названия " + name);
    }

}
