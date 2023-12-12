package backend;

import backend.model.Figure;
import backend.model.Point;
import frontend.MainFrame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CanvasState {


    MainFrame mainFrame;

    private final List<Figure> list = new ArrayList<>();


    public void addFigure(Figure figure) {
        list.add(figure);
    }

    public void deleteFigure() {
        if(selectedFigure.isEmpty()){return;}
        list.remove(selectedFigure.get());
    }

    public Iterable<Figure> figures() {
        return new ArrayList<>(list);
    }

    Optional<Figure> selectedFigure;

    public CanvasState(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        selectedFigure = Optional.empty();
    }

    public Optional<Figure> getSelectedFigure() {
        return selectedFigure;
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
        selectedFigure = ret;
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
        if(selectedFigure.isEmpty()){
            return;
        }
        selectedFigure.get().move(diffX, diffY);

    }

}
