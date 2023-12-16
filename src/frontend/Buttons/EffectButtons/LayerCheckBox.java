package frontend.Buttons.EffectButtons;

import backend.CanvasState;
import backend.model.FigureEffects;
import frontend.PaintPane_V2;
import javafx.scene.control.CheckBox;

public class LayerCheckBox extends CheckBox {

    private int layer;

    public LayerCheckBox(String name, PaintPane_V2 paintPane, CanvasState canvasState, int layer)
    {
        super(name);
        this.layer = layer;
        setSelected(true);
        setOnAction(event -> {
            canvasState.setLayerActive(layer, isSelected());
            paintPane.reDraw();
        });
    }
    public int getLayer(){
        return layer;
    }
}
