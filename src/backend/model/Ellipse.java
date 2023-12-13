package backend.model;

public class Ellipse extends Figure {

    private final Point centerPoint;
    private final double sMayorAxis, sMinorAxis;

    public Ellipse(Point centerPoint, double sMayorAxis, double sMinorAxis) {
        super(new Point[]{centerPoint});
        if (sMayorAxis <= 0 && sMinorAxis <= 0)
            throw new IllegalArgumentException("Los radios deben ser mayores a 0");
        this.centerPoint = centerPoint;
        this.sMayorAxis = sMayorAxis;
        this.sMinorAxis = sMinorAxis;
    }

    @Override
    public String toString() {
        return String.format("Elipse [Centro: %s, DMayor: %.2f, DMenor: %.2f]", centerPoint, sMayorAxis, sMinorAxis);
    }

    public Point getCenterPoint() {
        return centerPoint;
    }

    public double getsMayorAxis() {
        return sMayorAxis;
    }

    public double getsMinorAxis() {
        return sMinorAxis;
    }

    @Override
    public boolean contains(Point eventPoint) {
        return ((Math.pow(eventPoint.getX() - this.getCenterPoint().getX(), 2) / Math.pow(this.getsMayorAxis(), 2)) +
                (Math.pow(eventPoint.getY() - this.getCenterPoint().getY(), 2) / Math.pow(this.getsMinorAxis(), 2))) <= 0.30;
    }


    @Override
    public boolean isFullContained(Rectangle rectangle)
    {
        Point right = new Point(getCenterPoint().getX() + sMayorAxis/2,getCenterPoint().getY());
        Point left = new Point(getCenterPoint().getX() - sMayorAxis/2,getCenterPoint().getY());
        Point top = new Point(getCenterPoint().getX(),getCenterPoint().getY() + sMinorAxis/2);
        Point bottom = new Point(getCenterPoint().getX(),getCenterPoint().getY() - sMinorAxis/2);
        return rectangle.contains(right) && rectangle.contains(left) && rectangle.contains(top) && rectangle.contains(bottom);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Ellipse aux)){
            return false;
        }
        return centerPoint.equals(aux.getCenterPoint()) && (Double.compare(sMayorAxis, aux.getsMayorAxis()) == 0) &&
                (Double.compare(sMinorAxis,aux.getsMinorAxis())==0);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        getCenterPoint().move(deltaX,deltaY);
    }
}
