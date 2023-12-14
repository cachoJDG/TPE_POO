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

    private GraphicsContext gc;

    boolean hasShadow;
    boolean hasGradient;
    boolean hasBelved;

    public DrawableEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis, Color color1, GraphicsContext gc) {
        super(centerPoint, sMayorAxis, sMinorAxis);
        this.color = color1;
        this.gc = gc;
    }

    @Override
    public void draw(GraphicsContext gc) {

        if(hasShadow){
            drawShadow();
        }
        if(hasBelved){
            drawBelved();
        }
        gc.setFill(color);
        if(hasGradient){
            drawGradient();
        }


        if(isSelected())
        {
            gc.setStroke(Color.RED);
        }
        gc.strokeOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(),getsMinorAxis());
        gc.fillOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(), getsMinorAxis());


    }
    @Override
    public void shadow(boolean activated) {
        hasShadow = activated;

    }

    @Override
    public void gradient(boolean activated) {
        hasGradient = activated;

    }

    @Override
    public void belved(boolean activated) {
        hasBelved = activated;

    }



    public void drawShadow()
    {
        gc.setFill(Color.GRAY);
        gc.fillOval(getCenterPoint().getX() - (getsMayorAxis() / 2) + 10, getCenterPoint().getY() - (getsMinorAxis() / 2) +10, getsMayorAxis(), getsMinorAxis());
    }

    public void drawBelved()
    {
        double arcX = getCenterPoint().getX() - (getsMayorAxis() / 2);
        double arcY = getCenterPoint().getY() - (getsMinorAxis() / 2);
        gc.setLineWidth(10);
        gc.setStroke(Color.LIGHTGRAY);
        gc.strokeArc(arcX, arcY, getsMayorAxis(), getsMinorAxis() , 45, 180, ArcType.OPEN);
        gc.setStroke(Color.BLACK);
        gc.strokeArc(arcX, arcY, getsMayorAxis(), getsMinorAxis(), 225, 180, ArcType.OPEN);
        gc.setLineWidth(1);

    }

    public void drawGradient()
    {
        RadialGradient radialGradient = new RadialGradient(0.5, 0, 0.5, 0.5, 0.5, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, color),
                new Stop(1, color.invert()));
        gc.setFill(radialGradient);
    }



}
