package backend;

import backend.model.Figure;

import java.util.List;
import java.util.TreeMap;

public class FigureMap extends TreeMap<Integer, List<Figure>> {
    public void setLayerActive(int layer, boolean active)
    {
        if(!containsKey(layer)){
            return;
        }
        List<Figure> figs = get(layer);
        for (Figure fig:figs) {
            fig.setSelected(active);
        }
    }
}
