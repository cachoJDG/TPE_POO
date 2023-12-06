package backend.BOTTONS;

import backend.model.Figure;
import backend.model.Point;
import javafx.scene.control.ToggleButton;

public abstract class FigureButton extends ToggleButton {

    public FigureButton(String name){
        super(name);
    }

    public abstract Figure createFigure(Point startPoint, Point endPoint);

}
