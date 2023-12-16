package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.EnumMap;


public class RotateV extends ToolButton {

    public RotateV(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("RotateV");
       setOnAction(event -> mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.moveVertical())));
       // mainFrame.applyToSelected(fig -> fig.moveVertical());
    }




}