package backend.Buttons;

import backend.model.Circle;
import backend.model.Figure;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class CircleButton extends FigureButton {



    public CircleButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools,mainFrame);
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint) {
        double radius = Math.abs(endPoint.getX() - startPoint.getX());
        return new Circle(startPoint,radius);
    }
}