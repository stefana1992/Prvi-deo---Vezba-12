package drawing.model;

import java.util.ArrayList;

public class Polyline {

    private ArrayList<Line> segments;

    public Polyline() {

        this.segments = new ArrayList<>();
    }

    public ArrayList<Line> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<Line> segments) {
        this.segments = segments;
    }

    public boolean addSegment(Line segment) {
        if (this.segments.isEmpty()) {
            return this.segments.add(segment);
        } else {
            Object first = segment.getStartPoint();
            Object last = segments.get(segments.size() - 1).getEndPoint();
            if (first.equals(last)) {
                return this.segments.add(segment);
            }
        }
        return false;
    }

    public double length() {
        double length = 0.0;
        for (Line line : segments) {
            length += line.length();
        }
        return length;
    }
}