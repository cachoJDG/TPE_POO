package backend;

import backend.model.Point;
import javafx.scene.Cursor;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public abstract class ToolButton extends ToggleButton {

    public ToolButton(String name,ToggleGroup tools){
        super(name);
        setMinWidth(90);
        setToggleGroup(tools);
        setCursor(Cursor.HAND);
    }

    public abstract void act(Point startPoint, Point endPoint);

}
