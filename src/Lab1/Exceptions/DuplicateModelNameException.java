package Lab1.Exceptions;

/**
 * Created by Андрей on 25.02.2020.
 */
public class DuplicateModelNameException extends Exception {

    public DuplicateModelNameException(String name) {
        super("Одинаковое название модели " + name);
    }
}
