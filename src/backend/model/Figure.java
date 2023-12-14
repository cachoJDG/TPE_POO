package backend.model;

import backend.Movable;


public abstract class Figure implements Movable {

     final Point[] points;
     private boolean groupedFig;
     private boolean isSelected;
     private int groupNumber;


    protected Figure(Point[] points) {
        this.points = points;
        groupedFig = false;
        isSelected = false;
        groupNumber = 0;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public int getGroupNumber(){
        return groupNumber;
    }

    public void setGroupNumber(int n) {
        groupNumber = n;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public abstract boolean contains(Point eventPoint);

    public void shadow(boolean activated)
    {
        throw new UnsupportedOperationException();
    }

    public void belved(boolean activated)
    {
        throw new UnsupportedOperationException();
    }

    public void gradient(boolean activated)
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