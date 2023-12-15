package frontend.Drawable;

import backend.model.Ellipse;
import backend.model.FigureEffects;
import backend.model.Point;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;

import java.util.EnumMap;

public class DrawableEllipse extends Ellipse implements Drawable {

    private final Color color;

    private GraphicsContext gc;



    public DrawableEllipse(Point centerPoint, double sMayorAxis, double sMinorAxis, Color color1, GraphicsContext gc, EnumMap<FigureEffects,Boolean> map) {
        super(centerPoint, sMayorAxis, sMinorAxis, map);
        this.color = color1;
        this.gc = gc;
    }

    @Override
    public void draw() {

        if(hasEffect(FigureEffects.SHADOW)){
            drawShadow();
        }
        if(hasEffect(FigureEffects.BELVED)){
            drawBelved();
        }
        gc.setFill(color);
        if(hasEffect(FigureEffects.GRADIENT)){
            drawGradient();
        }


        if(isSelected())
        {
            gc.setStroke(Color.RED);
        }
        gc.strokeOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(),getsMinorAxis());
        gc.fillOval(getCenterPoint().getX() - (getsMayorAxis() / 2), getCenterPoint().getY() - (getsMinorAxis() / 2), getsMayorAxis(), getsMinorAxis());


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
