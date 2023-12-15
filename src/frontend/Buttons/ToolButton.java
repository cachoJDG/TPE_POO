package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.Cursor;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.paint.Color;

import java.util.EnumMap;

public abstract class ToolButton extends ToggleButton {

    MainFrame mainFrame;
    public ToolButton(ToggleGroup tools, MainFrame mainFrame){
        super("default");
        setMinWidth(30);
        setToggleGroup(tools);
        setCursor(Cursor.HAND);
        this.mainFrame = mainFrame;
        setOnAction(event -> {
            mainFrame.emptySelectedFig();
        });
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


    public void onMouseRelease(Point start, Point end, Color color, EnumMap<FigureEffects,Boolean> map, int layer)
    {

    }

}
