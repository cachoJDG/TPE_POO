package backend;

import backend.model.Figure;
import backend.model.Point;
import javafx.scene.control.ToggleGroup;

public abstract class FigureButton extends ToolButton{

    public FigureButton(String name,ToggleGroup tools){
        super(name,tools);
    };

    public abstract Figure createFigure(Point startPoint, Point endPoint);


    @Override
    public void act(Point startPoint, Point endPoint,CanvasState)
    {
        Figure newFig = createFigure(startPoint,endPoint);
       // canvasState.addFigure(newFig);
    }

}
