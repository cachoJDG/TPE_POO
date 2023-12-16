package frontend.Buttons;

import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class ScaleDown extends ToolButton{

    private final double SCALEDOWNMULTIPLIER = 0.75;

    public ScaleDown(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);

        setText("Scale-");
        setOnAction(event ->
        {
            mainFrame.applyToSelected(canvasState -> canvasState.applyToSelected(fig -> fig.scale(SCALEDOWNMULTIPLIER)));
            setSelected(false);
        });
    }
}
