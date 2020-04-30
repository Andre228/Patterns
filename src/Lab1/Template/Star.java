package Lab1.Template;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 * Created by Андрей on 29.04.2020.
 */
public class Star extends Figure {


    Polygon figure;

    public Star(Pane pane) {
        super(pane);
    }

    @Override
    public void setFigure() {
        figure = new Polygon();
        figure.getPoints().addAll(new Double[]{
                0.0, 8.0,
                2.5, 3.5,
                7.5, 2.5,
                4.0, -1.0,
                5.0, -6.0,
                0.0, -4.0,
                -5.0, -6.0,
                -4.0, -1.0,
                -7.5, 2.5,
                -2.5, 3.5,
        });
        figure.setScaleX(2);
        figure.setScaleY(2);
        figure.fillProperty().setValue(new Color(Math.random(),
                Math.random(), Math.random(), 0.8));
        figure.setLayoutX(getPane().getWidth()*0.93);
        figure.setLayoutY(getPane().getHeight()*0.93);

        super.setRadius(40);
        super.getPane().getChildren().add(figure);
        super.setFigure(figure);
    }
}
