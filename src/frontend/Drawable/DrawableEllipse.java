package frontend.Drawable;

import backend.model.Ellipse;
import backend.model.Point;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

public class DrawableEllipse extends Ellipse implements Drawable {

    private final Color color;
    private boolean is = false;

    GraphicsContext draw;

    public DrawableEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis, Color color1, GraphicsContext gc) {
        super(centerPoint, sMayorAxis, sMinorAxis);
        this.color = color1;
    }

    @Override
    public void draw(GraphicsContext gc) {
        draw = gc;
        if (is){
            gc.setFill(Color.GRAY);
            gc.fillOval(getCenterPoint().getX() - (getsMayorAxis() / 2) + 10, getCenterPoint().getY() - (getsMinorAxis() / 2) +10, getsMayorAxis(), getsMinorAxis());
        }

        gc.setFill(color);
        if(isSelected())
        {
            gc.setStroke(Color.RED);
        }
        gc.strokeOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(),getsMinorAxis());
        gc.fillOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(), getsMinorAxis());

    }

    @Override
    public void shadow() {
        is = true;
    }

}
