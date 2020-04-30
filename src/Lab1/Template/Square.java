package Lab1.Template;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

/**
 * Created by Андрей on 29.04.2020.
 */
public class Square extends Figure {
    Rectangle figure;

    public Square(Pane pane) {
        super(pane);
    }

    @Override
    public void setFigure() {
//        figure = new Polygon();
//        figure.getPoints().addAll(new Double[]{
//                0.0, 20.0,
//                20.0, 20.0,
//                20.0, 0.0,
//                0.0, 0.0,
//        });
        figure = new Rectangle();
        figure.setWidth(20);
        figure.setHeight(20);
        figure.fillProperty().setValue(new Color(Math.random(),
                Math.random(), Math.random(), 0.8));

        figure.setLayoutX(super.getPane().getWidth()*0.95);
        figure.setLayoutY(super.getPane().getHeight()*0.95);

        super.setRadius(30);
        super.getPane().getChildren().add(figure);
        super.setFigure(figure);
    }
}
