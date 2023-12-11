package frontend.Buttons;

import backend.model.Figure;
import backend.model.Point;
import frontend.Drawable.Drawable;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleGroup;

public abstract class FigureButton extends ToolButton {

    GraphicsContext gc;

    public FigureButton(ToggleGroup tools, MainFrame mainFrame, GraphicsContext gc) {
        super(tools,mainFrame);
    }


    @Override
    public void onMouseRelease(Point start, Point end)
    {
        Drawable newFig = createFigure(start,end);
        getMainFrame().drawFigure(newFig);
    }

    public abstract Drawable createFigure(Point startPoint, Point endPoint);



}