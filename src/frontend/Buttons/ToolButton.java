package frontend.Buttons;

import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.Cursor;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public abstract class ToolButton extends ToggleButton {

    MainFrame mainFrame;
    public ToolButton(ToggleGroup tools, MainFrame mainFrame){
        setMinWidth(90);
        setToggleGroup(tools);
        setCursor(Cursor.HAND);
        this.mainFrame = mainFrame;
    }

    protected MainFrame getMainFrame()
    {
        return mainFrame;
    }

    public void onMouseRelease(Point start, Point end)
    {

    }

    public void onMouseClicked(Point eventPoint)
    {

    }



}
