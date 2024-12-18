package frontend.Buttons;

import backend.model.Figure;
import backend.model.FigureEffects;
import backend.model.Point;

import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleGroup;

import javafx.scene.paint.Color;

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
        if(!getMainFrame().layerActive(layer)){
            return;
        }
        Figure newFig = createFigure(start,end,color, gc, map, layer);
        getMainFrame().applyToSelected(canvasState -> canvasState.addFigure(newFig, newFig.getLayer()));
    }

    public abstract Figure createFigure(Point startPoint, Point endPoint, Color color, GraphicsContext gc,EnumMap<FigureEffects,Boolean> map, int layer);



}