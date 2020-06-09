package drawing.model;


import java.awt.*;

public class Line extends Shape implements Movable {
    private Point startPoint;
    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        super();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Line(Point startPoint, Point endPoint, boolean selected) {
        super(selected);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public double length() {

        return startPoint.distance(endPoint);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Line) {
            Line l = (Line) obj;
            return this.startPoint.equals(l.startPoint) && this.endPoint.equals(l.endPoint);
        }
        return false;
    }

    public String toString() {
        return "Start:" + this.startPoint.toString() + ", End:" + this.endPoint.toString();
    }

    public boolean contains(Point p) {
        return this.startPoint.distance(p) + this.endPoint.distance(p) - this.length() <= 3.0D;
    }

    @Override
    public boolean contains(int x, int y) {
        return contains(new Point(x, y));
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
        if (this.selected) {
            g.setColor(Color.BLUE);
            g.drawRect(this.startPoint.getX() - 3, this.startPoint.getY() - 3, 6, 6);
            g.drawRect(this.endPoint.getX() - 3, this.endPoint.getY() - 3, 6, 6);
            g.setColor(Color.BLACK);
        }
    }

    @Override
    public void moveBy(int byX, int byY) {
        this.startPoint.moveBy(byX, byY);
        this.endPoint.moveBy(byX, byY);
    }
}