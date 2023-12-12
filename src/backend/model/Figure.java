package backend.model;

import backend.Movable;


public abstract class Figure implements Movable {

     final Point[] points;

    protected Figure(Point[] points) {
        this.points = points;
    }



    public abstract boolean contains(Point eventPoint);

}


/*
public interface Figure {

}*/