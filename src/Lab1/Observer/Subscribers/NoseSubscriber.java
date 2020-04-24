package Lab1.Observer.Subscribers;

import Lab1.Observer.Nose;
import Lab1.Observer.Observer;
import javafx.scene.paint.Color;

/**
 * Created by Андрей on 24.04.2020.
 */
public class NoseSubscriber implements Observer {

    private Nose nose;

    @Override
    public void handleEvent(Object component) {
        if (component instanceof Nose) {
            nose = (Nose)component;
            if (!nose.getNoseColor()) {
                setNoseRed();
                nose.setNoseColor();
            } else {
                setNoseDefault();
                nose.setNoseColor();
            }
        }
    }

    private void setNoseRed() {
        nose.getComponent().setFill(Color.MEDIUMVIOLETRED);
        nose.getComponent().setCenterX(nose.getFaceCenterX());
        nose.getComponent().setCenterY(nose.getFaceCenterY());
        nose.getComponent().setRadiusX(25);
        nose.getComponent().setRadiusY(35);
    }

    private void setNoseDefault() {
        nose.getComponent().setFill(Color.BLACK);
        nose.getComponent().setCenterX(nose.getFaceCenterX());
        nose.getComponent().setCenterY(nose.getFaceCenterY());
        nose.getComponent().setRadiusX(25);
        nose.getComponent().setRadiusY(35);
    }
}
