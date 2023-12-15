package frontend.Buttons;

import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;


public class RotateV extends ToolButton {

    public RotateV(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("RotateV");
        setOnAction(event ->
        {
           // mainFrame.rotateV();
            mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.moveVertical()));
        });
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color) {

    }
}