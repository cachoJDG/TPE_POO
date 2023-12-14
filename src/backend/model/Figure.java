package backend.model;

import backend.Movable;


public abstract class Figure implements Movable {

     final Point[] points;
     private boolean groupedFig;
     private boolean isSelected;


    protected Figure(Point[] points) {
        this.points = points;
        groupedFig = false;
        isSelected = false;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public abstract boolean contains(Point eventPoint);

    public void shadow()
    {
        throw new UnsupportedOperationException();
    }

    public void belved()
    {
        throw new UnsupportedOperationException();
    }

    public void gradient()
    {
        throw new UnsupportedOperationException();
    }


    public boolean isGroupedFig() {
        return groupedFig;
    }

    public void setGroupedFig(boolean groupedFig) {
        this.groupedFig = groupedFig;
    }

    // returns true if this Figure is fully contained
    public abstract boolean isFullContained(Rectangle rectangle);

}


/*
public interface Figure {

}*/