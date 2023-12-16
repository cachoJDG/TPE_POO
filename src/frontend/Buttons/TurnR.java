package frontend.Buttons;

import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class TurnR extends ToolButton {

    public TurnR(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("TurnR");
        setOnAction(event ->
        {
           // mainFrame.turnR();
            mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.turnR()));
        });
    }




}
