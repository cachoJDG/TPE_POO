package frontend.Buttons;

import backend.model.Circle;
import backend.model.Figure;
import backend.model.FigureEffects;
import backend.model.Point;

import frontend.Drawable.DrawableCircle;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleGroup;

import javafx.scene.paint.Color;

import java.util.EnumMap;

public class CircleButton extends FigureButton {

    public CircleButton(ToggleGroup tools, MainFrame mainFrame, GraphicsContext gc) {
        super(tools, mainFrame, gc);
        setText("Circle");
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint, Color color, GraphicsContext gc, EnumMap<FigureEffects,Boolean> map, int layer) {
        double radius = Math.abs(endPoint.getX() - startPoint.getX());
        return new DrawableCircle(startPoint,radius,color, gc, map,layer);
    }



}