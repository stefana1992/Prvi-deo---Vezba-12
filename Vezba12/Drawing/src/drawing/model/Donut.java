package drawing.model;

import java.awt.*;

public class Donut extends Circle {
    private int innerRadius;

    public Donut(Point center, int radius, int innerRadius) {
        super(center, radius);
        this.innerRadius = innerRadius;
    }

    public Donut(Point center, int radius, boolean selected, int innerRadius) {
        super(center, radius, selected);
        this.innerRadius = innerRadius;
    }

    public int getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(int innerRadius) throws Exception {
        if (innerRadius > this.radius)
            throw new Exception("Unutrasnji poluprecnik mora biti manji od poluprecnika spoljnog kruga!");
        this.innerRadius = innerRadius;
    }

    @Override
    public double area() {
        return super.area() - innerRadius * innerRadius * Math.PI;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Donut) {
            Donut d = (Donut) obj;
            return super.equals(d) && this.innerRadius == d.innerRadius;
        }
        return false;
    }

    public String toString() {
        return super.toString() + ", Innner radius:" + this.innerRadius;
    }


    public boolean contains(Point p) {
        return (center.distance(p) <= radius) && (center.distance(p) >= innerRadius);
    }

    @Override
    public boolean contains(int x, int y) {
        return contains(new Point(x, y));
    }


    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawOval(center.getX() - innerRadius, center.getY() - innerRadius, 2 * innerRadius, 2 * innerRadius);
        if (this.selected) {
            g.setColor(Color.BLUE);
            g.drawRect(this.center.getX() - 3, this.center.getY() - 3, 6, 6);
            g.drawRect(this.center.getX() - innerRadius - 3, this.center.getY() - 3, 6, 6);
            g.drawRect(this.center.getX() + innerRadius - 3, this.center.getY() - 3, 6, 6);
            g.drawRect(this.center.getX() - 3, this.center.getY() - innerRadius - 3, 6, 6);
            g.drawRect(this.center.getX() - 3, this.center.getY() + innerRadius - 3, 6, 6);
            g.setColor(Color.BLACK);
        }
    }


}