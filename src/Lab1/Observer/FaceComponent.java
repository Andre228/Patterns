package Lab1.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 16.04.2020.
 */
public class FaceComponent implements Observed {

    private List<Observer> observers = new ArrayList<>();

    public FaceComponent() {}

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Object object) {
        System.out.println(object);
        for(Observer observer: observers) {
            observer.handleEvent(object);
        }
    }
}
