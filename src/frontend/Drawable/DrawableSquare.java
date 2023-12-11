package frontend.Drawable;

import backend.model.Point;
import javafx.scene.canvas.GraphicsContext;

public class DrawableSquare extends DrawableRectangle {
    public DrawableSquare(Point topLeft, double size) {
        super(topLeft,new Point(topLeft.getX() + size, topLeft.getY() + size) );
    }
}
