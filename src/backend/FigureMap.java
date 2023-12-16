package backend;

import backend.model.Figure;

import java.awt.event.ActionEvent;
import java.util.List;
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


    public void putIfAbsent(Integer layer,List<Figure> list){
        putIfAbsent(layer,new Pair(list, true));
    }
    public static class Pair{
        private List<Figure> figList;
        private Boolean active;

        public Pair(List<Figure> figList, Boolean active) {
            this.figList = figList;
            this.active = active;
        }

        public Boolean getActive() {
            return active;
        }

        public void setActive(Boolean active) {
            this.active = active;
            for (Figure fig:figList) {
                fig.setToDraw(active);
            }
        }

        public List<Figure> getFigList() {
            return figList;
        }

        public void add(Figure figure) {
            figList.add(figure);
        }

        public void remove(Figure fig) {
            figList.remove(fig);
        }
    }
}
