package backend;

import backend.model.Figure;
import backend.model.Point;
import backend.model.Rectangle;
import javafx.scene.control.ToggleGroup;

public class RectangleButton extends FigureButton {

    public RectangleButton(String name,ToggleGroup tools){
        super(name,tools);
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint) {
        return new Rectangle(startPoint,endPoint);
    }

}
