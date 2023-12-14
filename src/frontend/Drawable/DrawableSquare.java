package frontend.Drawable;

import backend.model.Point;
import backend.model.Square;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawableSquare extends DrawableRectangle implements Drawable{

    private final Color color;
    private GraphicsContext gc;

    public DrawableSquare(Point topLeft, double size, Color color, GraphicsContext gc) {
        super(topLeft, new Point(topLeft.getX() + size, topLeft.getY() + size), color, gc);
        this.color = color;
        this.gc = gc;
    }

//    @Override
//    public void draw(GraphicsContext gc) {
//        gc.setFill(color);
//        if(isSelected())
//        {
//            gc.setStroke(Color.RED);
//        }
//        gc.fillRect(getTopLeft().getX(), getTopLeft().getY(),
//                Math.abs(getTopLeft().getX() - getBottomRight().getX()), Math.abs(getTopLeft().getY() - getBottomRight().getY()));
//        gc.strokeRect(getTopLeft().getX(), getTopLeft().getY(),
//                Math.abs(getTopLeft().getX() - getBottomRight().getX()), Math.abs(getTopLeft().getY() - getBottomRight().getY()));
//
//    }
}
