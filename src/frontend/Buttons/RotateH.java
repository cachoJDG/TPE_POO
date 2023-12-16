package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.EnumMap;


public class RotateH extends ToolButton {

    public RotateH(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("RotateH");
       // setOnAction(event -> mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.moveHorizontal())));
        mainFrame.applyToSelected(fig -> fig.moveHorizontal());

    }




}