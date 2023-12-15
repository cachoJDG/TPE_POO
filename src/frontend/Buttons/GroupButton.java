package frontend.Buttons;


import backend.model.FigureEffects;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.EnumMap;

public class GroupButton extends ToolButton {
    public GroupButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Group");
        setOnAction(event ->
        {
            mainFrame.group();
        });
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color, EnumMap<FigureEffects, Boolean> map) {

    }


}
