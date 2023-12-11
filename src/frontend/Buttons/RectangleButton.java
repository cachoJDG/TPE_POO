package frontend.Buttons;

import backend.model.Figure;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.Drawable.Drawable;
import frontend.Drawable.DrawableRectangle;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleGroup;

public class RectangleButton extends FigureButton {



    public RectangleButton(ToggleGroup tools, MainFrame mainFrame, GraphicsContext gc) {
        super(tools,mainFrame, gc);
    }

    @Override
    public Drawable createFigure(Point startPoint, Point endPoint) {
        return new DrawableRectangle(startPoint,endPoint);
    }

}