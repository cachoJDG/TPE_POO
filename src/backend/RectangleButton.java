package backend;

import backend.model.Figure;
import backend.model.Point;
import backend.model.Rectangle;
import javafx.scene.control.ToggleGroup;

public class RectangleButton extends FigureButton {

    public RectangleButton(ToggleGroup tools){
        super(tools);
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint) {
        return new Rectangle(startPoint,endPoint);
    }

}
