package frontend.Buttons;

import backend.CanvasState;
import backend.model.FigureEffects;
import backend.model.Point;
import frontend.CanvasStateRotAndScale;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.EnumMap;

public class UnGroup extends ToolButton{

    public UnGroup(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Ungroup");
        setOnAction(event -> mainFrame.rotAndScale(CanvasState::ungroup));
    }




}
