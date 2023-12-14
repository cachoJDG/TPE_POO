package frontend.Buttons;

import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;


public class RotateH extends ToolButton {

    public RotateH(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("RotateH");
        setOnAction(event ->
        {
            mainFrame.rotateH();
        });
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color) {

    }
}