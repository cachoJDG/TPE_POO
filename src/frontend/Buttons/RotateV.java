package frontend.Buttons;

import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;


public class RotateV extends ToolButton {

    public RotateV(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("RotateV");
        setOnAction(event ->
        {
            mainFrame.applyToSelected(canvasState -> canvasState.applyToSelected(fig -> fig.moveVertical()));
            setSelected(false);
        });
    }




}