package frontend.Buttons.EffectButtons;

import backend.CanvasState;
import backend.model.FigureEffects;
import frontend.PaintPane_V2;
import javafx.scene.control.CheckBox;

public class LayerCheckBox extends CheckBox {

    private PaintPane_V2 paintPane;
    private CanvasState canvasState;

    private int layer;

    //capaz ni los usamos estos
    public LayerCheckBox(String name, PaintPane_V2 paintPane, CanvasState canvasState, int layer, boolean isActivate)
    {
        super(name);
        this.layer = layer;
        this.paintPane = paintPane;
        this.canvasState = canvasState;
        setSelected(true);
        setOnAction(event -> {
            // canvasState.shadow(shadow.isSelected());
            canvasState.setLayerActive(layer, isSelected());
            this.paintPane.reDraw();
        });
    }
    public int getLayer(){
        return layer;
    }
}
