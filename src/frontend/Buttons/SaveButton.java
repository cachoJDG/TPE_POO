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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;


public class SaveButton extends ToolButton {


    public SaveButton(ToggleGroup tools, MainFrame mainFrame, TextArea textArea) {
        super(tools, mainFrame);
        setText("Guardar");
        setOnAction(event -> {
            String toSplit = textArea.getText();
            String[] lines = toSplit.split("[ |\n]");
            List<String> lines2 = new ArrayList<>(Arrays.stream(lines).toList());
            for (String s:lines2) {

            }

            lines2.remove("");

//            String input = "Hello\nWorld\n!";
//            String[] string = input.split("\n");
//            System.out.println(Arrays.stream(string).toList());
//            System.out.println(Arrays.stream(lines).toList());
            mainFrame.rotAndScale(canvasState -> canvasState.rotAndScale(fig -> fig.setLabels(lines2)));

        });

    }





}