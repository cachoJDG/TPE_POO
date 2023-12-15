package frontend.Buttons;

import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class TurnR extends OtherButton{

    public TurnR(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("TurnR");
        setOnAction(event ->
        {
           // mainFrame.turnR();
            mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.turnR()));
        });
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color) {

    }
}
