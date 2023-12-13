package backend.model;

import java.util.Objects;

public class Rectangle extends Figure {

    private final Point topLeft, bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        super(new Point[]{topLeft});
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        System.out.println(small());
    }

    public boolean small()
    {
        double SMALLDELTA = 30;
        return topLeft.getDistance(bottomRight) < SMALLDELTA;
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
       // return this.contains(rectangle.getBottomRight()) && this.contains(rectangle.getTopLeft()); // todo test this
        return rectangle.contains(getBottomRight()) && rectangle.contains(getTopLeft());
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Rectangle aux)){
            return false;
        }
        return this.topLeft.equals(aux.getTopLeft()) && this.bottomRight.equals(aux.getBottomRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }

    @Override
    public void move(double deltaX, double deltaY) {
        getTopLeft().move(deltaX,deltaY);
        getBottomRight().move(deltaX,deltaY);
    }
}
