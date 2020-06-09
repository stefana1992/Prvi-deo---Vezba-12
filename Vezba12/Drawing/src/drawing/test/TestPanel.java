package drawing.test;

import drawing.model.*;
import drawing.model.Point;
import drawing.model.Rectangle;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JPanel {

    @Override
    public void paint(Graphics g) {

        Point point = new Point(100, 200);
        point.draw(g);

        Line line = new Line(new Point(200, 200), new Point(300, 300));
        line.draw(g);

        Rectangle rectangle = new Rectangle(new Point(350, 200), 250, 100);
        rectangle.draw(g);

        Circle circle = new Circle(new Point(150, 400), 50);
        circle.draw(g);

        Donut donut = new Donut(new Point(300, 400), 60, 30);
        donut.draw(g);

    }
}