package frontend.Buttons;

import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public class DeleteButton extends ToolButton {

    public DeleteButton(ToggleGroup tools, MainFrame mainFrame){
        super(tools, mainFrame);
        setOnAction(event ->{
            getMainFrame().deleteFig();
        });
        setText("Delete");
    }


}
