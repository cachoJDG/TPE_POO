package backend.BUTTONS;

import backend.model.Circle;
import backend.model.Figure;
import backend.model.Point;
public class CircleButton extends FigureButton{

    public CircleButton(String name){
        super(name);
    }

    @Override
    public Figure createFigure(Point startPoint, Point endPoint) {
        double radius = Math.abs(endPoint.getX() - startPoint.getX());
        return new Circle(startPoint,radius);
    }
}