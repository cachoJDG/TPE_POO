package backend;

import backend.model.Figure;

import java.util.HashSet;

public class SelectionFigureSet extends HashSet<Figure> {

    public SelectionFigureSet(MultiSelectList<Figure> multSelectionFig) {
        super(multSelectionFig);
    }

    public void belved(boolean activated)
    {
        for (Figure fig:this) {
            fig.belved(activated);
        }
    }

    public void move(double diffX, double diffY)
    {
        for (Figure fig:this) {
            fig.move(diffX,diffY);
        }
    }

    public void shadow(boolean activated)
    {
        for (Figure fig:this) {
            fig.shadow(activated);
        }
    }

    public void gradient(boolean activated)
    {
        for (Figure fig:this) {
            fig.gradient(activated);
        }
    }


}
