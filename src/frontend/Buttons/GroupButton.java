package frontend.Buttons;


import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class GroupButton extends ToolButton {
    public GroupButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Group");
        setOnAction(event -> mainFrame.applyToSelected(canvasState -> canvasState.group()));
    }




}
