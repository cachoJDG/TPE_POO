package backend;

import backend.model.Figure;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.MainFrame;

import java.util.*;

public class CanvasState {


    private final MainFrame mainFrame;
  //  private Optional<Figure> singleSelectionFig;
    private int groupNum = 0;
    private MultiSelectList<Figure> multSelectionFig;
    private GroupFigureMap<Figure> groupMap;
    private final List<Figure> list = new ArrayList<>();


    public void addFigure(Figure figure) {
        list.add(figure);

    }

    public void deleteFigure() {
       // if(singleSelectionFig.isEmpty()){return;}
        for (Figure fig:multSelectionFig) {
            list.remove(fig);
        }
    }

    public Iterable<Figure> figures() {
        return new ArrayList<>(list);
    }



    public CanvasState(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        multSelectionFig = new MultiSelectList<>();
        groupMap = new GroupFigureMap<>();
       // singleSelectionFig = Optional.empty();
    }

    public void emptySelectedFig()
    {
       // singleSelectionFig = Optional.empty();
        multSelectionFig = new MultiSelectList<>();
        for (Figure fig:figures()) {
            fig.setSelected(false);
        }

    }



    public void multipleSelection(Rectangle selectionRect)
    {
        if(selectionRect.small()){
            return;
        }
        multSelectionFig = new MultiSelectList<>();
        for (Figure fig:figures()) {
            if(fig.isFullContained(selectionRect))
            {
                multSelectionFig.add(fig);
                fig.setSelected(true);
            }
        }
        if(multSelectionFig.isEmpty())
        {
            emptySelectedFig();
        }
    }

    public Optional<Figure> getSelectedFigure() {
        return multSelectionFig.getFirstCustom();
    }
    public String getLabelMouseMovedText(Point point)
    {
        String defaultStr = point.toString();
        StringBuilder label = new StringBuilder();
        Optional<Figure> ret = findFig(point,label);
        return ret.isPresent()? label.toString() : defaultStr;



        /*boolean found = false;
        for(Figure figure : figures()) {
            if(figure.contains(point)) {
                found = true;
                label.append(figure.toString());
            }
        }*/

    }

    public String getLabelSelectedText(Point point,StringBuilder label)
    {
        String defaultStr = "Ninguna figura Encontrada";
        multSelectionFig = new MultiSelectList<>();
        emptySelectedFig();
        Optional<Figure> ret = findFig(point,label);
       // singleSelectionFig = ret;
        ret.ifPresent(figure -> {figure.setSelected(true);
        multSelectionFig.add(figure);});
        return ret.isPresent()? label.toString() : defaultStr;
    }

    private Optional<Figure> findFig(Point point, StringBuilder label)
    {
        Optional<Figure> ret = Optional.empty();
        for(Figure figure : figures()) {
            if(figure.contains(point)) {
                ret = Optional.of(figure);
                label.append(figure.toString());
            }
        }
        return ret;
    }



    public void moveFig(double diffX, double diffY){

        moveGroup(getExtendedSelectionSet(),diffX,diffY);
    }

    private Set<Figure> getExtendedSelectionSet()
    {
        Set<Figure> multSelectionExtended = new HashSet<>(multSelectionFig);
        for (Figure fig:multSelectionFig) {
            if(fig.isGroupedFig())
            {
                multSelectionExtended.addAll(groupMap.findGroup(fig));
            }
        }
        return multSelectionExtended;
        //capaz conviene que el multSelectionExtended sea una
        //variable de instancia asi no lo tenemos q estar creando constantemente
    }

    private void moveGroup(Set<Figure> multiSelectionExtended,double diffx,double diffY)
    {
        for (Figure fig:multiSelectionExtended) {
            fig.move(diffx,diffY);
        }
    }

    public void group() {
        if(multSelectionFig.isEmpty()){return;}
        Set<Figure> aux = new HashSet<>();
        for (Figure fig:multSelectionFig) {
            if(fig.isGroupedFig()) {
                return;
            }
            aux.add(fig);
            fig.setGroupedFig(true);
        }
        groupMap.putIfAbsent(groupNum,aux);
        groupNum++;
    }
}
