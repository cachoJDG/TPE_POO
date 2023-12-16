package backend;

import backend.model.Figure;

import java.util.Collection;
import java.util.Collection;
import java.util.TreeMap;

public class FigureMap extends TreeMap<Integer, FigureMap.Pair> {
    public void setLayerActive(int layer, boolean active)
    {
        System.out.println("Layer " + layer +" Active :"+ active);
        if(!containsKey(layer)){
            return;
        }
        get(layer).setActive(active);

    }

    public void moveToLayer(Collection<Figure> list, int oldLayer, int newLayer)
    {
        moveToLayer(list,oldLayer,newLayer,true);
    }
    public void moveToLayer(Collection<Figure> list, int oldLayer, int newLayer,boolean startActiveLayer)
    {
        Collection<Figure> oldLayerCollection = get(oldLayer).getFigList();
        oldLayerCollection.removeAll(list);
        putIfAbsent(newLayer,list);
    }

    public void putIfAbsent(Integer layer,Collection<Figure> Collection,boolean startActiveLayer){
        putIfAbsent(layer,new Pair(Collection, startActiveLayer));
    }


    public void putIfAbsent(Integer layer,Collection<Figure> Collection){
        putIfAbsent(layer,Collection,true);
    }
    public static class Pair{
        private Collection<Figure> figCollection;
        private Boolean active;

        public Pair(Collection<Figure> figCollection, Boolean active) {
            this.figCollection = figCollection;
            setActive(active);
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
            for (Figure fig:figCollection) {
                fig.setActiveByLayer(active);
            }
        }

        public Collection<Figure> getFigList() {
            return figCollection;
        }

        public void add(Figure figure) {
            figCollection.add(figure);
        }

        public void remove(Figure fig) {
            figCollection.remove(fig);
        }
    }
}
