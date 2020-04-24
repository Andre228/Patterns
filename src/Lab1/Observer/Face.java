package Lab1.Observer;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.white;

/**
 * Created by Андрей on 15.04.2020.
 */
public class Face extends JPanel {

    public Face() {
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.drawArc(100, 45, 80, 80, 0, 360);

        g.setColor( Color.blue );
        g.drawArc( 120, 70, 10, 10, 0, 360);
        g.drawArc( 150, 70, 10, 10, 0, 360);

        g.setColor( Color.magenta );
        g.drawLine ( 140, 85, 140, 100 );

        g.setColor( Color.red );
        g.drawArc ( 110, 55, 60, 60, 0, -180 );
    }

    public void paint(Graphics g)
    {
        //Change color to yellow
        g.setColor(Color.green);
        //Draw and fill the face
        g.drawArc(100,100,250,250,0,360);
        g.fillArc(100,100,250,250,0,360);
        //Change color to black
        g.setColor(Color.black);
        //Draw the left eye
        g.drawArc(170,185,25,25,0,360);
        g.fillArc(170,185,25,25,0,360);

        //Draw the right eye
        g.drawArc(255,185,25,25,0,360);
        g.fillArc(255,185,25,25,0,360);

        //Draw the smile
        g.drawArc(150,215,150,100,0,-180);
    }

    public Graphics rightEye(Graphics g) {

        return g;
    }
}
