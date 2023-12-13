package frontend.Buttons;

import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class GroupeButton extends ToolButton{

    public GroupeButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);

    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color) {

    }


}
