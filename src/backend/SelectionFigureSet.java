package backend;

import backend.model.Figure;

import java.util.HashSet;

public class SelectionFigureSet extends HashSet<Figure> {

    public SelectionFigureSet(MultiSelectList<Figure> multSelectionFig) {
        super(multSelectionFig);
    }

    public void belved()
    {
        for (Figure fig:this) {
            fig.belved();
        }
    }

    public void move(double diffX, double diffY)
    {
        for (Figure fig:this) {
            fig.move(diffX,diffY);
        }
    }

    public void shadow()
    {
        for (Figure fig:this) {
            fig.shadow();
        }
    }

    public void gradient()
    {
        for (Figure fig:this) {
            fig.gradient();
        }
    }
}
