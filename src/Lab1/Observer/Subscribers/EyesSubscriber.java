package Lab1.Observer.Subscribers;

import Lab1.Observer.LeftEye;
import Lab1.Observer.Observer;
import Lab1.Observer.RightEye;

/**
 * Created by Андрей on 15.04.2020.
 */
public class EyesSubscriber implements Observer {
    @Override
    public void handleEvent(Object component) {
        System.out.println(component + "   Eye");
        if (component instanceof LeftEye) {
             LeftEye leftEye = (LeftEye)component;
             leftEye.openEyes();
        }
        if (component instanceof RightEye) {
            RightEye rightEye = (RightEye)component;
            rightEye.openEyes();
        }

    }
}
