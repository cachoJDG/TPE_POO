package backend.Buttons;

import frontend.MainFrame;
import javafx.scene.control.ToggleGroup;

public abstract class OtherButton extends ToolButton{

    public OtherButton(ToggleGroup tools, MainFrame mainFrame){
        super(tools,mainFrame);
    }

}
