package frontend.Buttons;

import backend.CanvasState;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class UnGroup extends ToolButton{

    public UnGroup(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Ungroup");
        setOnAction(event -> mainFrame.applyToSelected(CanvasState::ungroup));
    }




}
