package backend;

import javafx.scene.Cursor;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public abstract class ToolButton extends ToggleButton {

    public ToolButton(ToggleGroup tools){
        setMinWidth(90);
        setToggleGroup(tools);
        setCursor(Cursor.HAND);
    }

}
