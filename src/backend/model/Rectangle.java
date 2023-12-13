package backend.model;

public class Rectangle extends Figure {

    private final Point topLeft, bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        super(new Point[]{topLeft});
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    @Override
    public String toString() {
        return String.format("Rectángulo [ %s , %s ]", topLeft, bottomRight);
    }

    @Override
    public boolean contains(Point eventPoint) {
        return eventPoint.getX() > this.getTopLeft().getX() && eventPoint.getX() < this.getBottomRight().getX() &&
        eventPoint.getY() > this.getTopLeft().getY() && eventPoint.getY() < this.getBottomRight().getY();
    }

    @Override
    public boolean isFullContained(Rectangle rectangle) {
        return this.contains(rectangle.getBottomRight()) && this.contains(rectangle.getTopLeft()); // todo test this
    }

    @Override
    public void move(double deltaX, double deltaY) {
        getTopLeft().move(deltaX,deltaY);
        getBottomRight().move(deltaX,deltaY);
    }
}
