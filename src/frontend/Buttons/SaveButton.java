package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import frontend.Drawable.Drawable;
import frontend.Drawable.DrawableRectangle;
import frontend.MainFrame;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.EnumMap;


public class SaveButton extends ToolButton {


    public SaveButton(ToggleGroup tools, MainFrame mainFrame, TextArea textArea) {
        super(tools, mainFrame);
        setText("Guardar");
        setOnAction(event -> {
            System.out.println(textArea.getText());
            String toSplit = textArea.getText();
            String[] lines = toSplit.split("\n");
            
//            String input = "Hello\nWorld\n!";
//            String[] string = input.split("\n");
//            System.out.println(Arrays.stream(string).toList());
//            System.out.println(Arrays.stream(lines).toList());
//            mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.setLabels(lines)));

        });

    }


    @Override
    public void onMouseRelease(Point start, Point end, Color color, EnumMap<FigureEffects, Boolean> map) {

    }


}