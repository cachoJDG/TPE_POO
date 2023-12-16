package frontend.Buttons;

import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class ScaleUp extends ToolButton{

    private final double SCALEUPMULTIPLIER = 1.25;

    public ScaleUp(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Scale+");
        setOnAction(event ->
        {
            mainFrame.applyToSelected(canvasState -> canvasState.applyToSelected(fig -> fig.scale(SCALEUPMULTIPLIER)));
            setSelected(false);
        });
    }




}
