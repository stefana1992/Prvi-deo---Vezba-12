package drawing.model;

import java.awt.*;

public class Rectangle extends Shape implements Movable {
    private Point upperLeft;
    private int width;
    private int height;

    public Rectangle(Point upperLeft, int width, int height) {
        super();
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point upperLeft, int width, int height, boolean selected) {
        super(selected);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

    }

    public Point getUpperLeft() {
        return upperLeft;
    }

    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public boolean contains(Point p) {
        boolean containsX = p.getX() > this.upperLeft.getX() && p.getX() < this.upperLeft.getX() + this.width;
        boolean containsY = p.getY() > this.upperLeft.getY() && p.getY() < this.upperLeft.getY() + this.height;
        return containsX && containsY;
    }

    @Override
    public boolean contains(int x, int y) {
        return contains(new Point(x, y));
    }

    public Point lowerRight() {
        return new Point(upperLeft.getX() + width, upperLeft.getY() - height);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            Rectangle r = (Rectangle) obj;
            return this.upperLeft.equals(r.upperLeft) && this.width == r.width && this.height == r.height;
        }
        return false;
    }

    public String toString() {
        return "Left upper:" + this.upperLeft.toString() + ", Width: " + this.width + ", Height: " + this.height;
    }

    @Override
    public void draw(Graphics g) {
        g.drawRect(upperLeft.getX(), upperLeft.getY(), width, height);
        if (this.selected) {
            g.setColor(Color.BLUE);
            g.drawRect(this.upperLeft.getX() - 3, this.upperLeft.getY() - 3, 6, 6);
            g.drawRect(this.upperLeft.getX() + getWidth() - 3, this.upperLeft.getY() - 3, 6, 6);
            g.drawRect(this.upperLeft.getX() - 3, this.upperLeft.getY() + getHeight() - 3, 6, 6);
            g.drawRect(this.upperLeft.getX() + getWidth() - 3, this.upperLeft.getY() + getHeight() - 3, 6, 6);
            g.setColor(Color.BLACK);
        }
    }

    @Override
    public void moveBy(int byX, int byY) {
        this.upperLeft.moveBy(byX, byY);
    }
}