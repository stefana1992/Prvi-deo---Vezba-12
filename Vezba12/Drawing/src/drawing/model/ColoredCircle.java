package drawing.model;

import java.awt.*;

public class ColoredCircle extends Circle {
    private Color color;

    public ColoredCircle(Point center, int radius, Color color) {
        super(center, radius);
        this.color = color;
    }

    public ColoredCircle(Point center, int radius, boolean selected, Color color) {
        super(center, radius, selected);
        this.color = color;
    }


    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}