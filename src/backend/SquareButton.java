package backend;

import backend.model.Figure;
import backend.model.Point;
import backend.model.Square;
import javafx.scene.control.ToggleGroup;

public class SquareButton extends FigureButton {

    public SquareButton(ToggleGroup tools){
        super(tools);
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint) {
        double size = Math.abs(endPoint.getX() - startPoint.getX());
        return new Square(startPoint, size);
    }
}
