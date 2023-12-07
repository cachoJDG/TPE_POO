package backend.OLDTRASH;

import backend.model.Circle;
import backend.model.Figure;
import backend.model.Point;
import javafx.scene.control.ToggleGroup;

public class CircleButton extends EllipseButton{

    public CircleButton(ToggleGroup tools){
        super(tools
        );
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint) {
        double radius = Math.abs(endPoint.getX() - startPoint.getX());
        return new Circle(startPoint,radius);
    }
}
