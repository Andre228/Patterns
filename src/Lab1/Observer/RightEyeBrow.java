package Lab1.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Created by Андрей on 15.04.2020.
 */
public class RightEyeBrow {

    private Line rightEyeBrow = new Line();

    public RightEyeBrow() {

    }

    public void setComponent(double faceCenterX, double faceCenterY, double eyeBrowStartXFromFaceCenter,
                             double eyeBrowStartYFromFaceCenter, double eyeBrowEndXFromFaceCenter,
                             double eyeBrowEndYFromFaceCenter) {

        rightEyeBrow.setStartX(faceCenterX + eyeBrowStartXFromFaceCenter);
        rightEyeBrow.setStartY(faceCenterY - eyeBrowStartYFromFaceCenter);
        rightEyeBrow.setEndX(faceCenterX + eyeBrowEndXFromFaceCenter);
        rightEyeBrow.setEndY(faceCenterY - eyeBrowEndYFromFaceCenter);
        rightEyeBrow.setStrokeWidth(15.0);
        rightEyeBrow.setStroke(Color.BLACK);
        rightEyeBrow.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (rightEyeBrow.getStroke() == Color.BLACK)
                    rightEyeBrow.setStroke(Color.AZURE);
                else rightEyeBrow.setStroke(Color.BLACK);

            }
        });
    }

    public Line getComponent() {
        return rightEyeBrow;
    }
}
