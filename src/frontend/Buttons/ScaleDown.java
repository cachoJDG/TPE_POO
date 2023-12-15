package frontend.Buttons;

import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class ScaleDown extends OtherButton{
    public ScaleDown(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);

        setText("Scale-");
        setOnAction(event ->
        {
           // mainFrame.scaleDown();
            mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.scaleDown()));
        });
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color) {

    }
}
