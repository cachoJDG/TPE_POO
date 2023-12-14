package backend.model;

import backend.Movable;

public class Point implements Movable {

    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

//    public void setY(double y) {
//        this.y = y;
//    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("{%.2f , %.2f}", x, y);
    }

    public double getDistance(Point p)
    {
        return Math.sqrt(Math.pow(x-p.x,2) + Math.pow(y-p.y,2));
    }

    @Override
    public boolean equals(Object other) {
        if(this == other)
            return true;
        if (!(other instanceof Point ))
            return false;
        Point o = (Point) other;
        return Double.compare(o.x, x) == 0 && Double.compare(o.y, y) == 0;
    }

    @Override
    public void move(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
    }
}
