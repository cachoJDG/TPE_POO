package backend.Buttons;

import backend.model.Figure;
import backend.model.Point;
import backend.model.Square;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class SquareButton extends FigureButton {



    public SquareButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint) {
        double size = Math.abs(endPoint.getX() - startPoint.getX());
        return new Square(startPoint, size);
    }
}
