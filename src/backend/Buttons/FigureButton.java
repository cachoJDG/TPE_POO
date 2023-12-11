package backend.Buttons;

import backend.model.Figure;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public abstract class FigureButton extends ToolButton {


    public FigureButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools,mainFrame);
    }

    @Override
    public void onMouseRelease(Point start, Point end)
    {
        Figure newFig = createFigure(start,end);
        getMainFrame().drawFigure(newFig);
    }

    public abstract Figure createFigure(Point startPoint, Point endPoint);



}