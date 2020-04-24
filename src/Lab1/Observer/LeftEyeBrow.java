package Lab1.Observer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Created by Андрей on 15.04.2020.
 */
public class LeftEyeBrow {

    private Line leftEyebrow = new Line();

    public LeftEyeBrow() {
    }

    public void setComponent(double faceCenterX, double faceCenterY, double eyeBrowStartXFromFaceCenter,
                               double eyeBrowStartYFromFaceCenter, double eyeBrowEndXFromFaceCenter,
                               double eyeBrowEndYFromFaceCenter) {

        leftEyebrow.setStartX(faceCenterX - eyeBrowStartXFromFaceCenter);
        leftEyebrow.setStartY(faceCenterY - eyeBrowStartYFromFaceCenter);
        leftEyebrow.setEndX(faceCenterX - eyeBrowEndXFromFaceCenter);
        leftEyebrow.setEndY(faceCenterY - eyeBrowEndYFromFaceCenter);
        leftEyebrow.setStrokeWidth(15.0);
        leftEyebrow.setStroke(Color.BLACK);
        leftEyebrow.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (leftEyebrow.getStroke() == Color.BLACK)
                    leftEyebrow.setStroke(Color.AZURE);
                else leftEyebrow.setStroke(Color.BLACK);

            }
        });
    }

    public Line getComponent() {
        return leftEyebrow;
    }
}
