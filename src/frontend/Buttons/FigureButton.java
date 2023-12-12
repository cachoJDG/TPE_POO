package frontend.Buttons;

import backend.model.Point;
import frontend.Drawable.Drawable;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleGroup;

import javafx.scene.paint.Color;

public abstract class FigureButton extends ToolButton {

    GraphicsContext gc;

    public FigureButton(ToggleGroup tools, MainFrame mainFrame, GraphicsContext gc) {
        super(tools,mainFrame);
    }


    @Override
    public void onMouseRelease(Point start, Point end, Color color)
    {
        Drawable newFig = createFigure(start,end,color);
        getMainFrame().drawFigure(newFig);
    }

    public abstract Drawable createFigure(Point startPoint, Point endPoint, Color color);



}