package drawing.model;

import java.awt.*;

public class ColoredCircleWithText extends ColoredCircle {
    private String text;

    public ColoredCircleWithText(Point center, int radius, Color color, String text) {
        super(center, radius, color);
        this.text = text;
    }

    public ColoredCircleWithText(Point center, int radius, boolean selected, Color color, String text) {
        super(center, radius, selected, color);
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}