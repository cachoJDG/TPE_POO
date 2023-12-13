package backend.model;

import backend.Movable;


public abstract class Figure implements Movable {

     final Point[] points;

    protected Figure(Point[] points) {
        this.points = points;
    }



    public abstract boolean contains(Point eventPoint);


    // returns true if this Figure is fully contained
    public abstract boolean isFullContained(Rectangle rectangle);

}


/*
public interface Figure {

}*/