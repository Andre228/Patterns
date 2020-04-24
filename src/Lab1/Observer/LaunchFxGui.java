package Lab1.Observer;

import Lab1.Observer.Subscribers.EyesSubscriber;
import Lab1.Observer.Subscribers.MounthSubscriber;
import Lab1.Observer.Subscribers.NoseSubscriber;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by Андрей on 15.04.2020.
 */
public class LaunchFxGui extends Application {


        @Override
        public void start(Stage primaryStage) {
            double faceCenterX = 220.0;
            double faceCenterY = 220.0;
            double eyeYFromFaceCenter = 5.0;
            double eyeXFromFaceCenter = 80.0;
            double eyeBrowStartYFromFaceCenter = 50.0; //40
            double eyeBrowStartXFromFaceCenter = 40.0; //40
            double eyeBrowEndYFromFaceCenter = 40; //70
            double eyeBrowEndXFromFaceCenter = 100; //80

            //Само лицо
            Circle face = new Circle();
            face.setCenterX(faceCenterX);
            face.setCenterY(faceCenterY);
            face.setRadius(190.0);
            face.setFill(Color.LIGHTGREEN);
            face.setStrokeWidth(15.0);
            face.setStroke(Color.BLACK);

            FaceComponent faceComponent = new FaceComponent();

            //Нос
            Nose nose = new Nose(faceCenterX, faceCenterY, faceComponent);
            faceComponent.addObserver(new NoseSubscriber());
            nose.setComponent();


            //Левый глаз
            LeftEye leftEye = new LeftEye(faceCenterX, faceCenterY, eyeXFromFaceCenter, eyeYFromFaceCenter, faceComponent);
            faceComponent.addObserver(new EyesSubscriber());
            leftEye.setComponent();
            Circle leftEye1 = leftEye.getComponent()[0];
            Circle leftEye2 = leftEye.getComponent()[1];
            Circle pupil1 = leftEye.getComponent()[2];



            //Правый глаз
            RightEye rightEye = new RightEye(faceCenterX, faceCenterY, eyeXFromFaceCenter, eyeYFromFaceCenter, faceComponent);
            faceComponent.addObserver(new EyesSubscriber());
            rightEye.setComponent();
            Circle rightEye1 = rightEye.getComponent()[0];
            Circle rightEye2 = rightEye.getComponent()[1];
            Circle pupil2 = rightEye.getComponent()[2];

            //Левая бровь
            LeftEyeBrow leftEyeBrow = new LeftEyeBrow();
            leftEyeBrow.setComponent(faceCenterX,faceCenterY,eyeBrowStartXFromFaceCenter, eyeBrowStartYFromFaceCenter, eyeBrowEndXFromFaceCenter, eyeBrowEndYFromFaceCenter);

            //Правая бровь
            RightEyeBrow rightEyeBrow = new RightEyeBrow();
            rightEyeBrow.setComponent(faceCenterX,faceCenterY,eyeBrowStartXFromFaceCenter, eyeBrowStartYFromFaceCenter, eyeBrowEndXFromFaceCenter, eyeBrowEndYFromFaceCenter);

            //Рот
            Mouth mouth = new Mouth(faceCenterX,faceCenterY, faceComponent);
            faceComponent.addObserver(new MounthSubscriber());
            mouth.setComponent();


            Group root = new Group(face, nose.getComponent(), leftEye1, leftEye2, pupil1, rightEye1, rightEye2, pupil2, leftEyeBrow.getComponent(), rightEyeBrow.getComponent(), mouth.getComponent());
            Scene scene = new Scene(root, 450, 450);


            primaryStage.setTitle("FaceTime");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }

}
