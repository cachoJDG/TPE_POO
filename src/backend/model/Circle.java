package backend.model;

public class Circle extends Ellipse implements Figure  {

//    protected final Point centerPoint;
//    protected final double radius;

    public Circle(Point centerPoint, double radius) {
        super(centerPoint, radius, radius);
//        this.centerPoint = centerPoint;
//        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", centerPoint, sMinorAxis);
    }


    public double getRadius() {
        return sMinorAxis;
    }

}
