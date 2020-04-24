package Lab1.Observer;

/**
 * Created by Андрей on 15.04.2020.
 */
public interface Observed {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(Object object);
}
