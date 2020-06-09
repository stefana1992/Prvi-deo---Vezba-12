package drawing.model;

import java.awt.*;

public class Point extends Shape implements Movable {
    private int x;
    private int y;

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, boolean selected) {
        super(selected);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public double distance(Point p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        double d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point p = (Point) obj;
            return this.x == p.x && this.y == p.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }


    public boolean contains(Point p) {
        return this.distance(p) <= 2;
    }

    @Override
    public boolean contains(int x, int y) {
        return contains(new Point(x, y));
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
        g.drawLine(this.x - 2, this.y, this.x + 2, this.y);
        if (this.selected) {
            g.setColor(Color.BLUE);
            g.drawRect(this.x - 3, this.y - 3, 6, 6);
            g.setColor(Color.BLACK);
        }
    }

    @Override
    public void moveBy(int byX, int byY) {
        this.x += byX;
        this.y += byY;
    }


}