package backend.Buttons;

import backend.model.Ellipse;
import backend.model.Figure;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class EllipseButton extends FigureButton {



    public EllipseButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools,mainFrame);
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint) {
        Point centerPoint = new Point(Math.abs(endPoint.getX() + startPoint.getX()) / 2, (Math.abs((endPoint.getY() + startPoint.getY())) / 2));
        double sMayorAxis = Math.abs(endPoint.getX() - startPoint.getX());
        double sMinorAxis = Math.abs(endPoint.getY() - startPoint.getY());
        return new Ellipse(centerPoint, sMayorAxis, sMinorAxis);
    }


}