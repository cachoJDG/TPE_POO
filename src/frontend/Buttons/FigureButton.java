package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import frontend.Drawable.Drawable;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.paint.Color;

import java.util.Collection;
import java.util.EnumMap;

public abstract class FigureButton extends ToolButton{

    GraphicsContext gc;

    public FigureButton(ToggleGroup tools, MainFrame mainFrame, GraphicsContext gc) {
        super(tools,mainFrame);
        this.gc = gc;
    }


    @Override
    public void onMouseRelease(Point start, Point end, Color color,EnumMap<FigureEffects,Boolean> map, int layer)
    {
        Drawable newFig = createFigure(start,end,color, gc, map, layer);
        getMainFrame().drawFigure(newFig);
    }

    public abstract Drawable createFigure(Point startPoint, Point endPoint, Color color, GraphicsContext gc,EnumMap<FigureEffects,Boolean> map, int layer);



}