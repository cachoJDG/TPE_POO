package frontend.Buttons;

import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class ScaleUp extends OtherButton{

    public ScaleUp(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Scale+");
        setOnAction(event ->
        {
            mainFrame.scaleUp();
        });
    }
    @Override
    public void onMouseRelease(Point start, Point end, Color color) {

    }
}
