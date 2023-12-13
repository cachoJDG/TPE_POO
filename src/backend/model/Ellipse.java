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
    public boolean isFullContained(Rectangle rectangle) {
        Point tl = rectangle.getTopLeft();
        Point br = rectangle.getBottomRight();
        // ecuacion de internet para ver si una Ellipse esta completamente adentro de un rectangulo
        return tl.getX() <= centerPoint.getX() - sMayorAxis && centerPoint.getX() + sMayorAxis <= br.getX()
                && tl.getY() <= centerPoint.getY() - sMinorAxis && centerPoint.getY() + sMinorAxis <= br.getY();

    }

    @Override
    public void move(double deltaX, double deltaY) {
        getCenterPoint().move(deltaX,deltaY);
    }
}
