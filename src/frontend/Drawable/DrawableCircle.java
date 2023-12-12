package frontend.Drawable;

import backend.model.Circle;
import backend.model.Ellipse;
import backend.model.Point;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

public class DrawableCircle extends Circle implements Drawable {
    private final Color color;
    public DrawableCircle(Point centerPoint, double radius,Color color) {
        super(centerPoint, radius);
        this.color = color;
    }


    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.strokeOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(),getsMinorAxis());
        gc.fillOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(), getsMinorAxis());
    }
}