package frontend.Buttons;

import backend.model.Point;
import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

import java.awt.*;

public class DeleteButton extends ToolButton {

    public DeleteButton(ToggleGroup tools, MainFrame mainFrame){
        super(tools, mainFrame);
        setOnAction(event ->{
            getMainFrame().deleteFig();
        });
        setText("Delete");
    }

    @Override
    public void onMouseRelease(Point start, Point end, Color color) {

    }


}
