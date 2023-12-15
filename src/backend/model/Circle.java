package backend.model;

import java.util.EnumMap;

public class Circle extends Ellipse {


    public Circle(Point centerPoint, double radius, EnumMap<FigureEffects,Boolean> map) {
        super(centerPoint, radius, radius, map);
    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", getCenterPoint(), getsMayorAxis());
    }


    public double getRadius() {
        return getsMayorAxis() / 2;
    }

}
