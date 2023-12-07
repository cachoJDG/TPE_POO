package backend.OLDTRASH;

import backend.model.Figure;
import backend.model.Point;
import javafx.scene.control.ToggleGroup;

public abstract class FigureButton extends ToolButton{

    public FigureButton(ToggleGroup tools){
        super(tools);
    };

    public abstract Figure createFigure(Point startPoint, Point endPoint);

}
