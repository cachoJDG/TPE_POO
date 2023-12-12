package frontend.Buttons;

import backend.model.Figure;
import backend.model.Point;
import backend.model.Square;
import frontend.Drawable.Drawable;
import frontend.Drawable.DrawableSquare;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleGroup;

public class SquareButton extends FigureButton {


    public SquareButton(ToggleGroup tools, MainFrame mainFrame, GraphicsContext gc) {
        super(tools, mainFrame, gc);
        setText("Square");
    }

    @Override
    public Drawable createFigure(Point startPoint, Point endPoint) {
        double size = Math.abs(endPoint.getX() - startPoint.getX());
        return new DrawableSquare(startPoint, size);
    }
}
