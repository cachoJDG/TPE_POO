package frontend.Drawable;

import backend.model.FigureEffects;
import backend.model.Point;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

import java.util.EnumMap;

public class DrawableCircle extends DrawableEllipse implements Drawable {
    private final Color color;
    private final double radio;
    private GraphicsContext draw;

    public DrawableCircle(Point centerPoint, double radius,Color color, GraphicsContext gc, EnumMap<FigureEffects,Boolean> map, int layer) {
        super(centerPoint, radius, radius, color, gc, map,layer);
        this.radio = radius;
        this.color = color;
        this.draw = gc;
    }


//    @Override
//    public void draw(GraphicsContext gc) {
//
//        double diametro = radio * 2;
//
//        gc.setFill(Color.GRAY);
//        gc.fillOval(getCenterPoint().getX() - radio + 10, getCenterPoint().getY() - radio + 10, diametro,diametro);
//
//        gc.setFill(color);
//
//        if(isSelected())
//        {
//            gc.setStroke(Color.RED);
//        }
//
//
//        gc.strokeOval(getCenterPoint().getX() - radio, getCenterPoint().getY() - radio, diametro,diametro);
//        gc.fillOval(getCenterPoint().getX() - radio, getCenterPoint().getY() - radio, diametro, diametro);
//
//        gc.setStroke(Color.RED);
//
//
//    }

    @Override
    public String toString() {
        return String.format("Círculo [Centro: %s, Radio: %.2f]", getCenterPoint(), getsMayorAxis());
    }
}