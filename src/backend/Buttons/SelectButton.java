package backend.Buttons;

import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class SelectButton extends ToolButton{
    public SelectButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
    }


    @Override
    public void onMouseClicked(Point eventPoint)
    {
        getMainFrame().selectFig(eventPoint);
    }
}
