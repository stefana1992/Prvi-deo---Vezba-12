package drawing.exceptions;

import drawing.model.Circle;

public class CircleException extends Exception {
    private Circle circle;

    public CircleException(String message, Circle circle) {
        super(message);
        this.circle = circle;
    }

    public Circle getCircle() {
        return this.circle;
    }
}