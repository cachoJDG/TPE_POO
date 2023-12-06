package backend.model;

public class Square extends Rectangle implements Figure {


    public Square(Point topLeft, double size) {
        super(topLeft, new Point(topLeft.x + size, topLeft.y + size));
    }

//    public Point getTopLeft() {
//        return topLeft;
//    }
//
//    public Point getBottomRight() {
//        return bottomRight;
//    }

    @Override
    public String toString() {
        return String.format("Cuadrado [ %s , %s ]", getTopLeft(), getBottomRight());
    }

}
