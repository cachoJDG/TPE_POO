package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.EnumMap;

public class ScaleUp extends ToolButton{

    private final double SCALEUPMULTIPLIER = 1.25;

    public ScaleUp(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Scale+");
        setOnAction(event ->
        {
            //mainFrame.scaleUp();
            mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.scale(SCALEUPMULTIPLIER)));
            setSelected(false);
        });
    }




}
