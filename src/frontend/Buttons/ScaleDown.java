package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.EnumMap;

public class ScaleDown extends OtherButton{

    private final double SCALEDOWNMULTIPLIER = 0.75;

    public ScaleDown(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);

        setText("Scale-");
        setOnAction(event ->
        {
           // mainFrame.scaleDown();
            mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.scale(SCALEDOWNMULTIPLIER)));
        });
    }



}
