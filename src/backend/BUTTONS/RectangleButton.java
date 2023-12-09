package backend.Buttons;

import backend.model.Figure;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class RectangleButton extends FigureButton {



    public RectangleButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools,mainFrame);
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint) {
        return new Rectangle(startPoint,endPoint);
    }

}