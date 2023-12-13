package frontend.Buttons;


import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class GroupButton extends ToolButton {
    public GroupButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Group");
        setOnAction(event ->
        {

        });
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color) {

    }
}
