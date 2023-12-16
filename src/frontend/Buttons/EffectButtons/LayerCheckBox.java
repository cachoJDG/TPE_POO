package frontend.Buttons.EffectButtons;

import backend.CanvasState;
import backend.model.FigureEffects;
import frontend.PaintPane_V2;
import javafx.scene.control.CheckBox;

public class LayerCheckBox extends CheckBox {

    private PaintPane_V2 paintPane;
    private CanvasState canvasState;

    //capaz ni los usamos estos
    public LayerCheckBox(String name, PaintPane_V2 paintPane, CanvasState canvasState, int lay, boolean isActivate)
    {
        super(name);

        this.paintPane = paintPane;
        this.canvasState = canvasState;
        setOnAction(event -> {
            // canvasState.shadow(shadow.isSelected());
            canvasState.setLayerActive(lay, isSelected());
            this.paintPane.reDraw();
        });
    }
}
