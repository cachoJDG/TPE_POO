package frontend.Drawable;

import backend.model.Point;
import backend.model.Rectangle;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class DrawableRectangle extends Rectangle implements Drawable {

    private final Color color;
    private GraphicsContext gc;

    boolean hasShadow;
    boolean hasGradient;

    public DrawableRectangle(Point topLeft, Point bottomRight, Color color, GraphicsContext gc) {
        super(topLeft, bottomRight);
        this.color = color;
        this.gc = gc;

    }
    @Override
    public void draw(GraphicsContext gc) {      //Podriamos sacar esta peticion del gc
        if(hasShadow){
            drawShadow();
        }
        gc.setFill(color);
        if(hasGradient){
            drawGradient();
        }
        if(isSelected())
        {
            gc.setStroke(Color.RED);
        }
        gc.fillRect(getTopLeft().getX(), getTopLeft().getY(),
                Math.abs(getTopLeft().getX() - getBottomRight().getX()), Math.abs(getTopLeft().getY() - getBottomRight().getY()));
        gc.strokeRect(getTopLeft().getX(), getTopLeft().getY(),
                Math.abs(getTopLeft().getX() - getBottomRight().getX()), Math.abs(getTopLeft().getY() - getBottomRight().getY()));

    }
    public void drawShadow() {
        gc.setFill(Color.GRAY);
        gc.fillRect(getTopLeft().getX() + 10.0,
                getTopLeft().getY() + 10.0,
                Math.abs(getTopLeft().getX() - getBottomRight().getX()),
                Math.abs(getTopLeft().getY() - getBottomRight().getY()));
        gc.setFill(color);

    }

    @Override
    public void shadow() {
        hasShadow = true;
        draw(gc);
    }

    public void  drawGradient() {
        LinearGradient linearGradient = new LinearGradient(0, 0, 1, 0, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, color),
                new Stop(1, color.invert()));
        gc.setFill(linearGradient);
    }

    @Override
    public void gradient() {
        hasGradient = true;
        draw(gc);
    }
}
