package frontend.Buttons;

import backend.model.Figure;
import backend.model.FigureEffects;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.Drawable.Drawable;
import frontend.Drawable.DrawableRectangle;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.EnumMap;

public class RectangleButton extends FigureButton {



    public RectangleButton(ToggleGroup tools, MainFrame mainFrame, GraphicsContext gc) {
        super(tools,mainFrame, gc);
        setText("Rectangle");
    }

    @Override
    public Drawable createFigure(Point startPoint, Point endPoint, Color color, GraphicsContext gc, EnumMap<FigureEffects,Boolean> map) {
        return new DrawableRectangle(startPoint,endPoint, color, gc, map);
    }



}