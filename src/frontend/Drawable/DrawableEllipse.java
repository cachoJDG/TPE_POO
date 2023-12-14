package frontend.Drawable;

import backend.model.Ellipse;
import backend.model.Point;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;

public class DrawableEllipse extends Ellipse implements Drawable {

    private final Color color;

    private GraphicsContext draw;

    public DrawableEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis, Color color1, GraphicsContext gc) {
        super(centerPoint, sMayorAxis, sMinorAxis);
        this.color = color1;
        draw = gc;
    }

    @Override
    public void draw(GraphicsContext gc) {

        if(isSelected())
        {
            gc.setStroke(Color.RED);
        }
        gc.strokeOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(),getsMinorAxis());
        gc.fillOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(), getsMinorAxis());


    }

    public void shadow()
    {
        draw.setFill(Color.GRAY);
        draw.fillOval(getCenterPoint().getX() - (getsMayorAxis() / 2) + 10, getCenterPoint().getY() - (getsMinorAxis() / 2) +10, getsMayorAxis(), getsMinorAxis());
    }

    public void belved()
    {


    }

    public void gradient()
    {
        RadialGradient radialGradient = new RadialGradient(0.5, 0, 0.5, 0.5, 0.5, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, color),
                new Stop(1, color.invert()));
        draw.setFill(radialGradient);
    }



}
