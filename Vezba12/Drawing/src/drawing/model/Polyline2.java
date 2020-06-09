package drawing.model;

import java.util.ArrayList;

public class Polyline2 {
    private Line[] segments;
    private int lastSegmentIndex = -1;

    public Polyline2() {
        this.segments = new Line[10];
    }

    public Line[] getSegments() {
        return segments;
    }

    public void setSegments(Line[] segments) {
        this.segments = segments;
    }

    public boolean addSegment(Line newSegment) {
        if (this.lastSegmentIndex == -1) {
            this.segments[++lastSegmentIndex] = newSegment;
            return true;
        } else if (this.lastSegmentIndex == 9) {
            return false;
        } else {
            Line lastSegment = this.segments[lastSegmentIndex];
            if (lastSegment.getEndPoint().equals(newSegment.getStartPoint())) {
                this.segments[++lastSegmentIndex] = newSegment;
                return true;
            }
        }
        return false;
    }

    public double length() {
        if (this.lastSegmentIndex == -1) {
            return 0;
        }
        double totalLength = 0;
        for (int i = 0; i < this.segments.length; i++) {
            totalLength += this.segments[i].length();
            if (i == lastSegmentIndex) {
                break;
            }
        }
        return totalLength;
    }
}