package frontend.Buttons;

import backend.model.FigureEffects;
import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.EnumMap;

public class DeleteButton extends ToolButton {

    public DeleteButton(ToggleGroup tools, MainFrame mainFrame){
        super(tools, mainFrame);
        setOnAction(event ->{
            getMainFrame().deleteFig();
        });
        setText("Delete");
    }






}
