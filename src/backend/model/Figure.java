package backend.model;

import backend.Movable;

import java.util.*;


public abstract class Figure implements Movable {

     final Point[] points;
     private boolean groupedFig;
     private boolean isSelected;
     private int groupNumber;

    private boolean toDraw = true;

    private List<String> labels;


     private EnumMap<FigureEffects,Boolean> effectsMap;

     public void setToDraw(Boolean bool){
         toDraw = bool;
     }

     public boolean getToDraw(){
         return toDraw;
     }

     public boolean hasLabel(String text){
         return labels.contains(text);
     }


    protected Figure(Point[] points, EnumMap<FigureEffects,Boolean> map) {
        this.points = points;
        groupedFig = false;
        isSelected = false;
        groupNumber = 0;
        effectsMap = map;
        labels = new ArrayList<>();
    }

    public Figure(Point[] points) {
        this(points, new EnumMap<FigureEffects,Boolean>(FigureEffects.class));
    }
    public void setLabels(List<String> labels){

        this.labels = new ArrayList<>();
        this.labels.addAll(labels);
        System.out.println(labels);
    }

    public String getLabelsString()
    {
        StringBuilder sb = new StringBuilder();
        for (String s:labels) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
    public List<String> getLabelsList(){
        return labels;
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