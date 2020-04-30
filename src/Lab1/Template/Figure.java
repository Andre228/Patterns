package Lab1.Template;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.Random;

/**
 * Created by Андрей on 29.04.2020.
 */
public class Figure {

    public static Pane pane;
    private Shape figure;
    private int radius = 20;
    private Timeline animation;

    public Figure(Pane pane) {
        this.pane = pane;
    }

    public void setFigure(){
        figure = new Circle(10, new Color(Math.random(),
                Math.random(), Math.random(), 0.8));
        pane.getChildren().add(figure);
        figure.setLayoutX(pane.getWidth()*0.95);
        figure.setLayoutY(pane.getHeight()*0.95);
    }

    public static void removeFigure() {
        if (pane.getChildren().size() > 0) {
            pane.getChildren().remove(pane.getChildren().size() - 1);
        }
    }


    public void moveFigure() {
        animation = new Timeline(new KeyFrame(Duration.millis(50), new EventHandler<ActionEvent>() {

            Random random = new Random();

            double dx = -2 - random.nextInt(3);
            double dy = -2 - random.nextInt(3);

            @Override
            public void handle(ActionEvent t) {

                figure.setLayoutX(figure.getLayoutX() + dx);
                figure.setLayoutY(figure.getLayoutY() + dy);

                Bounds bounds = pane.getBoundsInLocal();


                if(figure.getLayoutX() >= (bounds.getMaxX() - radius) ){
                    figure.setLayoutX(bounds.getMaxX()-radius);
                    dx = -dx;
                }else if(figure.getLayoutX() <= (bounds.getMinX() + radius) ){
                    figure.setLayoutX(bounds.getMinX()+radius);
                    dx = -dx;
                }


                if(figure.getLayoutY() >= (bounds.getMaxY() - radius)){
                    figure.setLayoutY(bounds.getMaxY()-radius);
                    dy = -dy;
                }else if(figure.getLayoutY() <= (bounds.getMinY() + radius)){
                    figure.setLayoutY(bounds.getMinY()+radius);
                    dy = -dy;
                }
            }
        }));
    }

    public void play(){
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
        animation.setRate(
                animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    public Shape getFigure() {
        return figure;
    }

    public void setFigure(Shape figure) {
        this.figure = figure;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane mainPane) {
        this.pane = mainPane;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setAnimation(Timeline animation) {
        this.animation = animation;
    }

    public Timeline getAnimation() {
        return animation;
    }
}
