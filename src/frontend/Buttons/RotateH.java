package frontend.Buttons;

import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;


public class RotateH extends ToolButton {

    public RotateH(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("RotateH");

        setOnAction(event ->
        {
            mainFrame.applyToSelected(canvasState -> canvasState.applyToSelected(fig -> fig.moveHorizontal()));
            setSelected(false);
        });
    }




}