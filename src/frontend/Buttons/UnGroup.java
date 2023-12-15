package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.EnumMap;

public class UnGroup extends ToolButton{

    public UnGroup(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Ungroup");
        setOnAction(event ->
        {
            mainFrame.ungroup();
        });
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color, EnumMap<FigureEffects, Boolean> map) {

    }


}
