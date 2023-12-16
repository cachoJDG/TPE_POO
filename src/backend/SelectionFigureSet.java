package backend;

import backend.model.Figure;
import backend.model.FigureEffects;

import java.util.*;

public class SelectionFigureSet extends HashSet<Figure> {

    public SelectionFigureSet(Collection<Figure> multSelectionFig) {
        super(multSelectionFig);
    }
    public SelectionFigureSet() {
        super();
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

    public Optional<Figure> getFirstCustom()
    {
        if(isEmpty())
        {
            return Optional.empty();
        }
        return Optional.of(iterator().next());
    }

    public boolean onlyOne()
    {
        return size() <= 1;
    }

    public String getSelectedFigLabel()
    {
        if(isEmpty()){return "";}
        Figure fig = getFirstCustom().get();
        return fig.getLabelsString();
    }

    public boolean checkFigLayer() {
        Optional<Figure> first = getFirstCustom();
        if(first.isEmpty()){return false;}
        int firstLayerFound = first.get().getLayer();
        for (Figure fig : this)
        {
            if(fig.getLayer() != firstLayerFound){
                return true;
            }
        }
        return false;
    }


    public CheckBoxState getEffectState(FigureEffects effect)
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
            return CheckBoxState.UNDEFINED; //devuelve Indeterminado
        }
        if(activated > 0){
            return CheckBoxState.SELECTED; //solo hay activadas
        }
        else{
            return CheckBoxState.NOTSELECTED; //solo hay desactivadas
        }
    }
}
