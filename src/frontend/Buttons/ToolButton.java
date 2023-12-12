package frontend.Buttons;

import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.Cursor;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.paint.Color;

public abstract class ToolButton extends ToggleButton {

    MainFrame mainFrame;
    public ToolButton(ToggleGroup tools, MainFrame mainFrame){
        super("default");
        setMinWidth(90);
        setToggleGroup(tools);
        setCursor(Cursor.HAND);
        this.mainFrame = mainFrame;
    }

    protected MainFrame getMainFrame()
    {
        return mainFrame;
    }

//    public void onMouseRelease(Point start, Point end, Color color){
//
//    }

    public void onMouseClicked(Point eventPoint)
    {

    }


    public abstract void onMouseRelease(Point start, Point end, Color color);

}
