package Lab1.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;

/**
 * Created by Андрей on 24.04.2020.
 */
public class Nose {

    private Ellipse ellipse;
    private double faceCenterX;
    private double faceCenterY;
    private FaceComponent faceComponent;
    private boolean noseColor = false;

    public Nose(double faceCenterX, double faceCenterY, FaceComponent faceComponent) {

        this.faceCenterX = faceCenterX;
        this.faceCenterY = faceCenterY;
        this.faceComponent = faceComponent;
        this.ellipse = new Ellipse();


    }



    public void setComponent() {

        ellipse.setFill(Color.BLACK);
        ellipse.setCenterX(faceCenterX);
        ellipse.setCenterY(faceCenterY);
        ellipse.setRadiusX(25);
        ellipse.setRadiusY(35);
        ellipse.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                notifyObservers();
            }
        });
    }

    public Ellipse getComponent() {
        return ellipse;
    }

    public void notifyObservers() {
        faceComponent.notifyObservers(this);
    }

    public void setNoseColor() {
        noseColor = !noseColor;
    }

    public boolean getNoseColor() {
        return noseColor;
    }

    public double getFaceCenterX() {
        return faceCenterX;
    }

    public double getFaceCenterY() {
        return faceCenterY;
    }
}
