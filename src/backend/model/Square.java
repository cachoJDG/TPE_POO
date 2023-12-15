package backend.model;

import java.util.EnumMap;

public class Square extends Rectangle {


    public Square(Point topLeft, double size, EnumMap<FigureEffects,Boolean> map) {

        super(topLeft, new Point(topLeft.getX() + size, topLeft.getY() + size), map);
    }

    @Override
    public String toString() {
        return String.format("Cuadrado [ %s , %s ]", getTopLeft(), getBottomRight());
    }

}
