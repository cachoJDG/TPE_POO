package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.EnumMap;

public class ScaleUp extends OtherButton{

    public ScaleUp(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Scale+");
        setOnAction(event ->
        {
            //mainFrame.scaleUp();
            mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.scaleUp()));
        });
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color, EnumMap<FigureEffects, Boolean> map) {

    }


}
