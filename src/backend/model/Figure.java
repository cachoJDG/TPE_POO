package backend.model;

import backend.Movable;
import frontend.Buttons.ScaleUp;
import javafx.scene.transform.Scale;

import java.util.*;


public abstract class Figure implements Movable {

     final Point[] points;
     private boolean groupedFig;
     private boolean isSelected;
     private int groupNumber;

    private List<String> Labels;


     private EnumMap<FigureEffects,Boolean> effectsMap;


    protected Figure(Point[] points, EnumMap<FigureEffects,Boolean> map) {
        this.points = points;
        groupedFig = false;
        isSelected = false;
        groupNumber = 0;
        effectsMap = map;
        Labels = new ArrayList<>();
    }

    public Figure(Point[] points) {
        this(points, new EnumMap<FigureEffects,Boolean>(FigureEffects.class));
    }
    public void setLabels(String[] labels){

        Labels.addAll(Arrays.stream(labels).toList());
        System.out.println(Labels);
    }


    public boolean hasEffect(FigureEffects effect)
    {
        return effectsMap.get(effect);
    }

    public void setEffect(FigureEffects effect,Boolean activated)
    {
        effectsMap.put(effect,activated);
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

    public abstract void scale(double multiplier);

    public abstract void scaleDown();

}


/*
public interface Figure {

}*/