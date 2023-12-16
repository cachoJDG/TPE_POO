package frontend.Buttons.EffectButtons;

import backend.CanvasState;
import backend.model.FigureEffects;
import frontend.PaintPane_V2;
import javafx.scene.control.CheckBox;

public class EffectsCheckBox extends CheckBox {
    private FigureEffects effect;
    private PaintPane_V2 paintPane;
    private CanvasState canvasState;

    //capaz ni los usamos estos
    public EffectsCheckBox(String name,FigureEffects effect, PaintPane_V2 paintPane, CanvasState canvasState)
    {
        super(name);
        this.effect = effect;
        this.paintPane = paintPane;
        this.canvasState = canvasState;
        setOnAction(event -> {
            // canvasState.shadow(shadow.isSelected());
           // this.canvasState.setEffect(effect,isSelected());
            canvasState.applyToSelected(set -> set.applyToSet(fig -> fig.setEffect(effect,isSelected())));
            this.paintPane.reDraw();
        });
    }
}
