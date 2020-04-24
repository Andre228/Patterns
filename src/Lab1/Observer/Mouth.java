package Lab1.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 15.04.2020.
 */
public class Mouth {

  //  private List<Observer> observers = new ArrayList<>();

    private Arc mouth = null;//(220,310,80,60,0,180);
    private double faceCenterX;
    private double faceCenterY;
    private boolean isSmile = false;
    private FaceComponent faceComponent;

    public Mouth(double faceCenterX, double faceCenterY, FaceComponent faceComponent) {

        this.faceCenterX = faceCenterX;
        this.faceCenterY = faceCenterY;
       // mouth = new Arc(faceCenterX, faceCenterY + 90, 80, 60, 0, 180);
        mouth = new Arc(faceCenterX, faceCenterY + 110, 80, 60, 0, 180);
        this.faceComponent = faceComponent;


    }

    public void setComponent() {

        mouth.setFill(null);
        mouth.setStroke(Color.BLACK);
        mouth.setStrokeWidth(15.0);
        mouth.setType(ArcType.OPEN);

        mouth.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                notifyObservers();
            }
        });
    }

    public Arc getComponent() {
        return mouth;
    }

    public boolean getIsSmile() {
        return isSmile;
    }

    public double getFaceCenterX() {
        return faceCenterX;
    }

    public double getFaceCenterY() {
        return faceCenterY;
    }

    public void setIsSmile(boolean bool) {
        isSmile = bool;
    }

//    public void addObserver(Observer observer) {
//        faceComponent.addObserver(observer);
//    }
//
//    public void removeObserver(Observer observer) {
//        faceComponent.removeObserver(observer);
//    }

    public void notifyObservers() {
        faceComponent.notifyObservers(this);
    }
}
