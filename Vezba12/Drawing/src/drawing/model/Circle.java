package drawing.model;

import drawing.exceptions.CircleException;

import java.awt.*;

public class Circle extends Shape implements Movable {
    protected Point center;
    protected int radius;

    public Circle(Point center, int radius) {
        super();
        this.center = center;
        this.radius = radius;
    }

    public Circle(Point center, int radius, boolean selected) {
        super(selected);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) throws CircleException {
        if (radius <= 0)
            throw new CircleException("Poluprecnik mora biti veci od 0!", Circle.this);
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }

    public boolean contains(Point p) {
        return this.center.distance(p) <= this.radius;
    }

    public boolean contains(int x, int y) {
        return contains(new Point(x, y));
    }

    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle c = (Circle) obj;
            return this.center.equals(c.center) && this.radius == c.radius;
        }
        return false;
    }

    public String toString() {
        return "Center:" + this.center.toString() + ", Radius:" + this.radius;
    }

    @Override
    public void draw(Graphics g) {

        g.drawOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
        if (this.selected) {
            g.setColor(Color.BLUE);
            g.drawRect(this.center.getX() - 3, this.center.getY() - 3, 6, 6);
            g.drawRect(this.center.getX() - radius - 3, this.center.getY() - 3, 6, 6);
            g.drawRect(this.center.getX() + radius - 3, this.center.getY() - 3, 6, 6);
            g.drawRect(this.center.getX() - 3, this.center.getY() - radius - 3, 6, 6);
            g.drawRect(this.center.getX() - 3, this.center.getY() + radius - 3, 6, 6);
            g.setColor(Color.BLACK);
        }
    }

    @Override
    public void moveBy(int byX, int byY) {
        this.center.moveBy(byX, byY);
    }
}