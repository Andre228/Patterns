package Lab1.Template;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

/**
 * Created by Андрей on 29.04.2020.
 */
public class LaunchGui extends Application {

    Pane ballPane = new Pane();
    ScrollBar sbSpeed = new ScrollBar();

    @Override
    public void start(Stage primaryStage) {


        ballPane.setStyle("-fx-border-color: yellow");

        Button btAdd = new Button("+ Круг");
        Button btAddS = new Button("+ Квадрат");
        Button btAddSt = new Button("+ Звезда");
        Button btSubtract = new Button("- Удалить");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btAdd, btAddS, btAddSt, btSubtract);
        hBox.setAlignment(Pos.CENTER);



        btAdd.setOnAction(e -> FigureAction.addCircle(ballPane, sbSpeed));
        btAddS.setOnAction(e -> FigureAction.addSquare(ballPane, sbSpeed));
        btAddSt.setOnAction(e -> FigureAction.addStar(ballPane, sbSpeed));
        btSubtract.setOnAction(e -> FigureAction.remove());


        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);


        Scene scene = new Scene(pane, 500, 400);
        primaryStage.setTitle("Симулятор DVD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
