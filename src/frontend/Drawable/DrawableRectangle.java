package frontend.Drawable;

import backend.model.Point;
import backend.model.Rectangle;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

public class DrawableRectangle extends Rectangle implements Drawable {

    private final Color color;
    private GraphicsContext gc;

    public DrawableRectangle(Point topLeft, Point bottomRight, Color color, GraphicsContext gc) {
        super(topLeft, bottomRight);
        this.color = color;
        this.gc = gc;

    }
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        if(isSelected())
        {
            gc.setStroke(Color.RED);
        }
        gc.fillRect(getTopLeft().getX(), getTopLeft().getY(),
                Math.abs(getTopLeft().getX() - getBottomRight().getX()), Math.abs(getTopLeft().getY() - getBottomRight().getY()));
        gc.strokeRect(getTopLeft().getX(), getTopLeft().getY(),
                Math.abs(getTopLeft().getX() - getBottomRight().getX()), Math.abs(getTopLeft().getY() - getBottomRight().getY()));

    }

    @Override
    public void shadow() {

    }
}
