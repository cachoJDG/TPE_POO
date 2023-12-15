package backend;

import backend.model.Figure;
import backend.model.FigureEffects;

import java.util.HashSet;

public class SelectionFigureSet extends HashSet<Figure> {

    public SelectionFigureSet(MultiSelectList<Figure> multSelectionFig) {
        super(multSelectionFig);
    }

    public void move(double diffX, double diffY)
    {
        for (Figure fig:this) {
            fig.move(diffX,diffY);
        }
    }

    public void applyToSet(FigureSetApply func)
    {
        for (Figure fig : this){
            func.apply(fig);
        }
    }


    public void setEffect(FigureEffects effect, Boolean activated)
    {
        for (Figure fig:this) {
            fig.setEffect(effect,activated);
        }
    }

    public int getEffectState(FigureEffects effect)
    {
        int activated = 0;
        int deActivated = 0;
        for (Figure fig:this) {
            if(fig.hasEffect(effect))
            {
                activated++;
            }
            else {
                deActivated++;
            }
        }

        if(activated > 0 && deActivated > 0){
            return 0; //devuelve Indeterminado
        }
        if(activated > 0){
            return 1; //solo hay activadas
        }
        else{
            return -1; //solo hay desactivadas
        }
    }
}
