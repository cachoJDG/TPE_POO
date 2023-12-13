package backend;

import backend.model.Figure;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.MainFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CanvasState {


    private final MainFrame mainFrame;
    private Optional<Figure> singleSelectionFig;
    private List<Figure> multSelectionFig;

    private final List<Figure> list = new ArrayList<>();


    public void addFigure(Figure figure) {
        list.add(figure);
    }

    public void deleteFigure() {
        if(singleSelectionFig.isEmpty()){return;}
        list.remove(singleSelectionFig.get());
    }

    public Iterable<Figure> figures() {
        return new ArrayList<>(list);
    }



    public CanvasState(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        singleSelectionFig = Optional.empty();
    }

    public void emptySelectedFig()
    {
        singleSelectionFig = Optional.empty();
    }

    public void multipleSelection(Rectangle selectionRect)
    {
        multSelectionFig = new ArrayList<>();
        for (Figure fig:figures()) {
            if(fig.isFullContained(selectionRect))
            {
                multSelectionFig.add(fig);
            }
        }
    }

    public Optional<Figure> getSelectedFigure() {
        return singleSelectionFig;
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
        //aca deberia hacer findFig de nuevo, el problema es que este tendria que actualizar
        //el selectedFig (que por ahora esta en mainframe) y al mismo tiempo tambien devolver
        //el texto correcto
        Optional<Figure> ret = findFig(point,label);
        singleSelectionFig = ret;
        singleSelectionFig.ifPresent(figure -> figure.setSelected(true));
        return ret.isPresent()? label.toString() : defaultStr;
    }

    private Optional<Figure> findFig(Point point, StringBuilder label)
    {
        Optional<Figure> ret = Optional.empty();
        for(Figure figure : figures()) {

            figure.setSelected(false);

            if(figure.contains(point)) {
                ret = Optional.of(figure);
                label.append(figure.toString());
            }
        }
        return ret;
    }



    public void moveFig(double diffX, double diffY){
        if(singleSelectionFig.isEmpty()){
            return;
        }
        singleSelectionFig.get().move(diffX, diffY);

    }

}
