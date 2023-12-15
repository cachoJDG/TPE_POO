package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

import javafx.scene.paint.Color;

import java.security.spec.EncodedKeySpec;
import java.util.EnumMap;

public class SelectButton extends ToolButton{
    public SelectButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Select");
    }


    @Override
    public void onMouseClicked(Point eventPoint)
    {
       getMainFrame().selectFig(eventPoint);
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color, EnumMap<FigureEffects,Boolean> map, int layer)
    {

        Rectangle selectionRect = new Rectangle(start,end);
        mainFrame.selectFig(selectionRect);
    }


}
