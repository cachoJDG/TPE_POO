package backend;

import backend.model.Figure;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.MainFrame;

import java.util.*;

public class CanvasState {


    private final MainFrame mainFrame;
  //  private Optional<Figure> singleSelectionFig;
    private MultiSelectList<Figure> multSelectionFig;

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
        return multSelectionFig.getFirst();
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
        //aca deberia hacer findFig de nuevo, el problema es que este tendria que actualizar
        //el selectedFig (que por ahora esta en mainframe) y al mismo tiempo tambien devolver
        //el texto correcto
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
      //  if(singleSelectionFig.isEmpty() && multSelectionFig.isEmpty()){
      //      return;
     //   }
//        singleSelectionFig.ifPresent(figure -> figure.move(diffX, diffY));
//        for (:
//             ) {
//
//        }
        for (Figure fig:multSelectionFig) {
            fig.move(diffX,diffY);
        }

    }

}
