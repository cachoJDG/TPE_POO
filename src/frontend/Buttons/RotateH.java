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
        setOnAction(event ->
        {
           // mainFrame.rotateH();
            mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.moveHorizontal()));
        });
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color, EnumMap<FigureEffects, Boolean> map) {

    }


}