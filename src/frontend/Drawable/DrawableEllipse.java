package frontend.Drawable;

import backend.model.Ellipse;
import backend.model.Point;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

public class DrawableEllipse extends Ellipse implements Drawable {

    private final Color color;

    public DrawableEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis, Color color1) {
        super(centerPoint, sMayorAxis, sMinorAxis);
        this.color = color1;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.strokeOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(),getsMinorAxis());
        gc.fillOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(), getsMinorAxis());
    }
}
