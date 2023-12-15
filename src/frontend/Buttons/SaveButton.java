package frontend.Buttons;

import backend.model.Point;
import frontend.Drawable.Drawable;
import frontend.Drawable.DrawableRectangle;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;


public class SaveButton extends ToolButton {


    public SaveButton(ToggleGroup tools, MainFrame mainFrame) {
        super(tools, mainFrame);
        setText("Guardar");
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color) {

    }
}