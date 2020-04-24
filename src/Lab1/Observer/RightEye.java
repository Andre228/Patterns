package Lab1.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Андрей on 15.04.2020.
 */
public class RightEye implements Eye {

    private Circle[] rightEye = new Circle[3];
    private List<Observer> observers = new ArrayList<>();
    private double faceCenterX;
    private double faceCenterY;
    private double eyeXFromFaceCenter;
    private double eyeYFromFaceCenter;
    private boolean isOpen = false;
    private FaceComponent faceComponent;

    public RightEye(double faceCenterX, double faceCenterY, double eyeXFromFaceCenter, double eyeYFromFaceCenter, FaceComponent faceComponent) {
        this.faceCenterX = faceCenterX;
        this.faceCenterY = faceCenterY;
        this.eyeXFromFaceCenter = eyeXFromFaceCenter;
        this.eyeYFromFaceCenter = eyeYFromFaceCenter;
        this.faceComponent = faceComponent;
    }

    public void setComponent() {

        rightEye[0] = new Circle();
        rightEye[1] = new Circle();
        rightEye[2] = new Circle();


        rightEye[0].setCenterX(faceCenterX + eyeXFromFaceCenter);
        rightEye[0].setCenterY(faceCenterY - eyeYFromFaceCenter);

        rightEye[1].setCenterX(faceCenterX + eyeXFromFaceCenter);
        rightEye[1].setCenterY(faceCenterY - eyeYFromFaceCenter);

        //Зрачок
        rightEye[2].setCenterX(faceCenterX + eyeXFromFaceCenter + 5);
        rightEye[2].setCenterY(faceCenterY - eyeYFromFaceCenter + 5);

        rightEye[0].setRadius(25.0);
        rightEye[0].setFill(Color.BLACK);
        rightEye[0].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openCloseEye();
                   notifyObservers();
            }
        });

        rightEye[1].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                openCloseEye();
                   notifyObservers();
            }
        });
    }

    public Circle[] getComponent() {
        return rightEye;
    }

    public boolean getIsOpen() {
        return isOpen;
    }

    private void openCloseEye() {
        if (rightEye[0].getFill() == Color.BLACK && !isOpen) {

            rightEye[1].setRadius(15.0);
            rightEye[1].setFill(Color.WHITE);

            rightEye[2].setRadius(5.0);
            rightEye[2].setFill(Color.BLACK);

        }

        if (rightEye[1].getFill() == Color.WHITE && isOpen) {
            rightEye[1].setFill(Color.BLACK);

        }
        isOpen = !isOpen;
    }

    public void addObserver(Observer observer) {
        faceComponent.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        faceComponent.removeObserver(observer);
    }

    public void notifyObservers() {
        this.faceComponent.notifyObservers(this);
    }

    @Override
    public void openEyes() {
        openCloseEye();
    }

    public RightEye getRightEye() {
        return this;
    }
}
