package backend.model;

import backend.Movable;


public abstract class Figure implements Movable {

     final Point[] points;
     private boolean groupedFig;
     private boolean isSelected;
     private int groupNumber;

    public boolean hasShadow() {
        return hasShadow;
    }



    public boolean hasBelved() {
        return hasBelved;
    }



    public boolean hasGradient() {
        return hasGradient;
    }



    private boolean hasShadow;
     private boolean hasBelved;
     private boolean hasGradient;


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
        hasShadow = activated;
    }

    public void belved(boolean activated)
    {
        hasBelved = activated;
    }

    public void gradient(boolean activated)
    {
        hasGradient = activated;
    }


    public boolean isGroupedFig() {
        return groupedFig;
    }

    public void setGroupedFig(boolean groupedFig) {
        this.groupedFig = groupedFig;
    }

    // returns true if this Figure is fully contained
    public abstract boolean isFullContained(Rectangle rectangle);

    public abstract void moveHorizontal();

    public abstract void moveVertical();

    public abstract void turnR();

}


/*
public interface Figure {

}*/