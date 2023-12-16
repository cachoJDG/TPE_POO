package frontend.Buttons;

import frontend.MainFrame;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SaveButton extends ToolButton {


    public SaveButton(ToggleGroup tools, MainFrame mainFrame, TextArea textArea) {
        super(tools, mainFrame);
        setText("Guardar");
        setOnAction(event -> {
            String toSplit = textArea.getText();
            String[] lines = toSplit.split("[ |\n]");
            List<String> lines2 = new ArrayList<>(Arrays.stream(lines).toList());
            lines2.remove("");
            mainFrame.applyToSelected(canvasState -> canvasState.applyToSelected(fig -> fig.setLabels(lines2)));

        });

    }





}