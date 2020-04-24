package Lab1.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 15.04.2020.
 */
public class LeftEye implements Eye {

    private Circle[] leftEye = new Circle[3];
    private List<Observer> observers = new ArrayList<>();
    private double faceCenterX;
    private double faceCenterY;
    private double eyeXFromFaceCenter;
    private double eyeYFromFaceCenter;
    private boolean isOpen = false;
    private FaceComponent faceComponent;

    public LeftEye(double faceCenterX, double faceCenterY, double eyeXFromFaceCenter, double eyeYFromFaceCenter, FaceComponent faceComponent) {
        this.faceCenterX = faceCenterX;
        this.faceCenterY = faceCenterY;
        this.eyeXFromFaceCenter = eyeXFromFaceCenter;
        this.eyeYFromFaceCenter = eyeYFromFaceCenter;
        this.faceComponent = faceComponent;
    }

    public void setComponent() {

        leftEye[0] = new Circle();
        leftEye[1] = new Circle();
        leftEye[2] = new Circle();


        leftEye[0].setCenterX(faceCenterX - eyeXFromFaceCenter);
        leftEye[0].setCenterY(faceCenterY - eyeYFromFaceCenter);

        leftEye[1].setCenterX(faceCenterX - eyeXFromFaceCenter);
        leftEye[1].setCenterY(faceCenterY - eyeYFromFaceCenter);

        //Зрачок
        leftEye[2].setCenterX(faceCenterX - eyeXFromFaceCenter + 5);
        leftEye[2].setCenterY(faceCenterY - eyeYFromFaceCenter + 5);

        leftEye[0].setRadius(25.0);
        leftEye[0].setFill(Color.BLACK);
        leftEye[0].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openCloseEye();
                notifyObservers();
            }
        });

        leftEye[1].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openCloseEye();
                   notifyObservers();
            }
        });
    }

    public Circle[] getComponent() {
        return leftEye;
    }

    public boolean getIsOpen() {
        return isOpen;
    }


    public void addObserver(Observer observer) {
        this.faceComponent.addObserver(observer);
    }


    public void removeObserver(Observer observer) {
        this.faceComponent.removeObserver(observer);
    }


    public void notifyObservers() {
        this.faceComponent.notifyObservers(this);
    }

    public void openCloseEye() {
        if (leftEye[0].getFill() == Color.BLACK && !isOpen) {

            leftEye[1].setRadius(15.0);
            leftEye[1].setFill(Color.WHITE);

            leftEye[2].setRadius(5.0);
            leftEye[2].setFill(Color.BLACK);

        }

        if (leftEye[1].getFill() == Color.WHITE && isOpen) {
            leftEye[1].setFill(Color.BLACK);

        }
        isOpen = !isOpen;
    }

    @Override
    public void openEyes() {
        openCloseEye();
    }

    public LeftEye getLeftEye() {
        return this;
    }
}
