package backend.model;

import backend.Movable;

import java.util.*;


public abstract class Figure implements Movable {

     final Point[] points;
     private boolean groupedFig;
     private boolean isSelected;
     private int groupNumber;
     private int layer;

     private boolean isActiveLayer = true;
     private boolean isActiveLabels = true;

     private List<String> labels;


     private EnumMap<FigureEffects,Boolean> effectsMap;

     public void setActiveByLayer(boolean bool){
         isActiveLayer = bool;
     }

     public void setActiveByLabelCheck(boolean bool)
     {
         isActiveLabels = bool;
     }

     public boolean getActive(){
         return isActiveLayer && isActiveLabels;
     }

     public boolean hasLabel(String text){
         return labels.contains(text);
     }


     public void draw()
     {
         throw new UnsupportedOperationException();
     }

    protected Figure(Point[] points, EnumMap<FigureEffects,Boolean> map, int layer) {
        this.points = points;
        groupedFig = false;
        isSelected = false;
        groupNumber = 0;
        effectsMap = map;
        labels = new ArrayList<>();
        this.layer = layer;
    }

    public Figure(Point[] points) {
        this(points, new EnumMap<>(FigureEffects.class),0);
    }
    public void setLabels(List<String> labels){

        this.labels = new ArrayList<>();
        this.labels.addAll(labels);

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

    public abstract boolean isFullContained(Rectangle rectangle);

    public abstract void moveHorizontal();

    public abstract void moveVertical();

    public abstract void turnR();

    public abstract void scale(double multiplier);

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }
}