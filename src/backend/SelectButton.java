package backend;

import backend.model.Point;
import javafx.scene.control.ToggleGroup;

public class SelectButton extends ToolButton{
    public SelectButton(String name, ToggleGroup tools) {
        super(name, tools);
    }

    @Override
    public void act(Point startPoint, Point endPoint) {

    }
}
