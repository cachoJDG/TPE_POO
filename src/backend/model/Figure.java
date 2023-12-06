package backend.model;

import backend.Movable;


public abstract class Figure implements Movable {

     final Point[] points;

    protected Figure(Point[] points) {
        this.points = points;
    }

    @Override
    public void move(double deltaX, double deltaY) {
        for (Point p : points)
            p.move(deltaX, deltaY);
    }

}


/*
public interface Figure {

}*/