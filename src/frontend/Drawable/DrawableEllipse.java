package frontend.Drawable;

import backend.model.Ellipse;
import backend.model.Point;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;

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


        draw.setFill(color);
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
        double arcX = getCenterPoint().getX() - (getsMayorAxis() / 2);
        double arcY = getCenterPoint().getY() - (getsMinorAxis() / 2);
        draw.setLineWidth(10);
        draw.setStroke(Color.LIGHTGRAY);
        draw.strokeArc(arcX, arcY, getsMayorAxis(), getsMinorAxis() , 45, 180, ArcType.OPEN);
        draw.setStroke(Color.BLACK);
        draw.strokeArc(arcX, arcY, getsMayorAxis(), getsMinorAxis(), 225, 180, ArcType.OPEN);
        draw.setLineWidth(1);

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
