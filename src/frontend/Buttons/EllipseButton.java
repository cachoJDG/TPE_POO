package frontend.Buttons;

import backend.model.Figure;
import backend.model.FigureEffects;
import backend.model.Point;

import frontend.Drawable.DrawableEllipse;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleGroup;

import javafx.scene.paint.Color;

import java.util.EnumMap;

public class EllipseButton extends FigureButton {

    public EllipseButton(ToggleGroup tools, MainFrame mainFrame, GraphicsContext gc) {
        super(tools,mainFrame,gc);
        setText("Ellipse");
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint, Color color, GraphicsContext gc, EnumMap<FigureEffects,Boolean> map, int layer) {
        Point centerPoint = new Point(Math.abs(endPoint.getX() + startPoint.getX()) / 2, (Math.abs((endPoint.getY() + startPoint.getY())) / 2));
        double sMayorAxis = Math.abs(endPoint.getX() - startPoint.getX());
        double sMinorAxis = Math.abs(endPoint.getY() - startPoint.getY());
        return new DrawableEllipse(centerPoint, sMayorAxis, sMinorAxis, color, gc, map,layer);
    }



}