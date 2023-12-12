package frontend.Buttons;

import backend.model.Circle;
import backend.model.Figure;
import backend.model.Point;
import frontend.Drawable.Drawable;
import frontend.Drawable.DrawableCircle;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleGroup;

import java.awt.*;

public class CircleButton extends FigureButton {


    public CircleButton(ToggleGroup tools, MainFrame mainFrame, GraphicsContext gc) {
        super(tools, mainFrame, gc);
        setText("Circle");
    }

    @Override
    public Drawable createFigure(Point startPoint, Point endPoint, Color color) {
        double radius = Math.abs(endPoint.getX() - startPoint.getX());
        return new DrawableCircle(startPoint,radius,color);
    }
}