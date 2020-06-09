package drawing.test;

import drawing.exceptions.CircleException;
import drawing.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class TestGeometry {
    public static void main(String[] args) {
       /* Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);

        System.out.println("Udaljenost: " + p1.distance(p2));

        Circle c = new Circle(null, 3);
        c.setRadius(3);
        System.out.println("Povrsina kruga je: " + c.area());


        Rectangle r = new Rectangle(null, 6, 4);
        r.setWidth(6);
        r.setHeight(4);
        System.out.println("Povrsina pravougaonika: " + r.area());


        Point p3 = new Point(5, 6);
        System.out.println("x = " + p3.getX());
        System.out.println("y = " + p3.getY());
        System.out.println("selected: " + p3.isSelected());

        Point p4 = new Point(10, 20, true);
        p3.setSelected(p4.isSelected());
        System.out.println("Is point p3 selected: " + p3.isSelected());

        Point p5 = p3;
        p3.setX(9);
        System.out.println("Vrednost tacke X na koju ukazuje referenca p5 je: " + p5.getX());

        Point p6 = new Point(p3.getX(), p3.getY());
        System.out.println("Vrednost tacke X : " + p6.getX());
        System.out.println("Vrednost tacke Y : " + p6.getY());

        Point p8 = new Point(10, 20);
        Point p9 = new Point(30, 40);
        p9 = p8;

        System.out.println("Upisite parametre za kreiranje tacke:");
        Scanner scanner = new Scanner(System.in);
        String pointInput = scanner.nextLine();

        System.out.println("Unos je: " + pointInput);

        String[] strArray = pointInput.split(" ");

        int x = Integer.parseInt(strArray[0]);
        int y = Integer.parseInt(strArray[1]);
        Point pointFromInput = null;

        if (strArray.length == 2) {
            pointFromInput = new Point(x, y);
        }
        if (strArray.length == 3) {
            boolean selected = Boolean.parseBoolean(strArray[2]);
            pointFromInput = new Point(x, y, selected);
        }

        System.out.println("Koordinate tacke su:");
        System.out.println("X = " + pointFromInput.getX());
        System.out.println("Y = " + pointFromInput.getY());
        System.out.println("Selektovanost tacke: " + pointFromInput.isSelected());
        */


     /*   Point p = new Point(3, 2);
        System.out.println(p);

        Line l2 = new Line(new Point(4, 5), new Point(6, 3));
        System.out.println(l2);

        Rectangle rec = new Rectangle(new Point(3, 4), 2, 4);
        System.out.println(rec);

        Circle cir = new Circle(new Point(10, 20), 30);
        System.out.println(cir);

        Donut don = new Donut(new Point(3, 4), 5, 2);
        System.out.println(don);

        Polyline pol = new Polyline();
        Line l = new Line(new Point(2, 4), new Point(4, 5));
        Line li = new Line(new Point(2, 8), new Point(7, 5));
        pol.getSegments().add(l);
        pol.getSegments().add(li);
        pol.addSegment(l2);
        System.out.println("Ukupna duzina polilinije: " + pol.length());

        Polyline2 pol2 = new Polyline2();
        Line[] line = new Line[10];
        line[0] = new Line(new Point(1, 2), new Point(2, 5));
        line[1] = new Line(new Point(2, 5), new Point(4, 5));
        pol2.setSegments(line);
        pol2.addSegment(l2);
        System.out.println("Ukupna duzina polilinije: " + pol2.length());*/


        //Vezba9
       /* ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Point(101, 201));
        shapes.add(new Line(new Point(50, 100), new Point(300, 600)));
        shapes.add(new Circle(new Point(200, 300), 200));
        shapes.add(new Rectangle(new Point(50, 40), 80, 170));

        System.out.println("Da li elementi sadrze tacku sa koordinatama x=100, y=200 ?");
        for (Shape shape : shapes) {
            System.out.println(shape.toString() + " " + shape.contains(100, 200));
        }

        ArrayList<Movable> movables = new ArrayList<>();
        movables.addAll(shapes);

        System.out.println("\nElementi pomereni za 20 po x i 30 po y osi:");
        for (Movable movable : movables) {
            movable.moveBy(20, 30);
            System.out.println(movable);
        }*/

        //Vezba10
        Donut donut = new Donut(new Point(2, 3), 300, 100);
        try {
            System.out.println("Unesite unutrasnji poluprecnik:");
            Scanner scanner = new Scanner(System.in);
            String inputInnerRadius = scanner.nextLine();
            donut.setInnerRadius(Integer.parseInt(inputInnerRadius));

            System.out.println("Unesite poluprecnik spoljnog kruga donut-a:");
            scanner = new Scanner(System.in);
            String inputRadius = scanner.nextLine();
            donut.setRadius(Integer.parseInt(inputRadius));
        } catch (NumberFormatException nfe) {
            System.out.println("Greska pri konverziji u int " + nfe.getMessage());
        } catch (CircleException cex) {
            System.out.println(cex.getMessage() + " Circle: " + cex.getCircle());
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}