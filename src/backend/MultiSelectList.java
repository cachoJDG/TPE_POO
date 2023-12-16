package backend;

import backend.model.Figure;

import java.util.ArrayList;
import java.util.Optional;

public class MultiSelectList extends ArrayList<Figure> {

    public Optional<Figure> getFirstCustom()
    {
        if(isEmpty())
        {
            return Optional.empty();
        }
        return Optional.of(get(0));
    }

    public boolean onlyOne()
    {
        return size() <= 1;
    }

    public String getSelectedFigLabel()
    {
        if(isEmpty()){return "";}
        StringBuilder sb = new StringBuilder();
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

    public void setSelectedLayer(int layer)
    {
        for (Figure fig:this) {
            fig.setLayer(layer);
        }

        //no se si lo vamos a usar capaz conviene usar el extended set
        //mañana vemos
    }
}
