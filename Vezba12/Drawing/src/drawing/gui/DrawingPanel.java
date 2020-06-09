package drawing.gui;

import drawing.model.*;

import javax.swing.*;

import java.awt.Graphics;
import java.util.ArrayList;

public class DrawingPanel extends JPanel {

    private ArrayList<Shape> shapes = new ArrayList<>();

    private Point startPoint;

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Shape shape : this.shapes) {
            shape.draw(g);
        }
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }
}