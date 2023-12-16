package backend.model;

import java.util.EnumMap;

public class Square extends Rectangle {

    public Square(Point topLeft, double size, EnumMap<FigureEffects,Boolean> map, int layer) {

        super(topLeft, new Point(topLeft.getX() + size, topLeft.getY() + size), map,layer);
    }
    @Override
    public String toString() {
        return String.format("Cuadrado [ %s , %s ]", getTopLeft(), getBottomRight());
    }

}
