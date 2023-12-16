package backend;

import backend.model.Figure;
import backend.model.FigureEffects;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.MainFrame;
import javafx.scene.control.TextArea;

import java.util.*;

public class CanvasState {


    private final MainFrame mainFrame;
  //  private Optional<Figure> singleSelectionFig;
    private int groupNum = 1;
    private SelectionFigureSet multSelectionFig;
    private GroupFigureMap groupMap;
    private final FigureMap figMap = new FigureMap();

    public CanvasState(MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        multSelectionFig = new SelectionFigureSet();
        groupMap = new GroupFigureMap();
        // singleSelectionFig = Optional.empty();
    }

    public void setLabels(List<String> lines) {
        //SelectionFigureSet set =  getExtendedSelectionSet();
        getExtendedSelectionSet().applyToSet(fig -> fig.setLabels(lines));
    }


    public void setEffect(FigureEffects effect, Boolean activated)
    {
       // getExtendedSelectionSet().setEffect(effect, activated);
        getExtendedSelectionSet().applyToSet(fig -> fig.setEffect(effect,activated));
    }



    public void addFigure(Figure figure, int layer) {
        figMap.putIfAbsent(layer,new ArrayList<>());
        figMap.get(layer).add(figure);
    }

    public void setLayerActive(int layer,boolean active)
    {
        figMap.setLayerActive(layer, active);
    }

    public void deleteFigure() {
       // if(singleSelectionFig.isEmpty()){return;}
        for (Figure fig:getExtendedSelectionSet()) {
            figMap.get(fig.getLayer()).remove(fig);
        }
    }

    public Collection<Figure> figures() {
        List<Figure> figs = new ArrayList<>();
        for (Integer i : figMap.keySet()) {
            figs.addAll(figures(i));
        }
        return figs;
    }

    public Collection<Figure> figures(int layer)
    {
        if(!figMap.containsKey(layer))
        {
            return  new ArrayList<>();
        }
        return figMap.get(layer).getFigList();
    }





    public void emptySelectedFig()
    {
       // singleSelectionFig = Optional.empty();
        multSelectionFig = new SelectionFigureSet();
        for (Figure fig:figures()) {
            fig.setSelected(false);
        }
        updateCheckBoxes();
        mainFrame.UpdateTextArea(false, "");
        mainFrame.UpdateChoiceBox(false);
    }



    public void multipleSelection(Rectangle selectionRect)
    {
        String textAreaTest = "";
        boolean deActivate;

        if(selectionRect.small()){
            return;
        }
        multSelectionFig = new SelectionFigureSet();
        for (Figure fig:figures()) {
            if(fig.isFullContained(selectionRect) && fig.getActive())
            {
                multSelectionFig.add(fig);
                fig.setSelected(true);
            }
        }
        if(multSelectionFig.isEmpty()) {
            emptySelectedFig();
        }
        deActivate = !multSelectionFig.onlyOne();
        if(deActivate){
            textAreaTest = getLabels();
        }

        mainFrame.UpdateTextArea(deActivate, textAreaTest);
        mainFrame.UpdateChoiceBox(multSelectionFig.checkFigLayer());
        updateCheckBoxes();
    }

    private String getLabels()
    {
        StringBuilder textAreaTest = new StringBuilder();
        SelectionFigureSet set = getExtendedSelectionSet();
        for (Figure fig : set){
            textAreaTest.append(fig.getLabelsString());
        }
        return textAreaTest.toString();
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
    }

    public String onSingleSelect(Point point,StringBuilder label)
    {

        String defaultStr = "Ninguna figura Encontrada";
        multSelectionFig = new SelectionFigureSet();
        emptySelectedFig();
        Optional<Figure> ret = findFig(point,label);
       // singleSelectionFig = ret;
        ret.ifPresent(figure -> {figure.setSelected(true);
        multSelectionFig.add(figure);});


        multSelectionFig.getFirstCustom().ifPresent(fig -> System.out.println(fig.getLayer()));



        mainFrame.UpdateTextArea(false, multSelectionFig.getSelectedFigLabel());
        mainFrame.UpdateChoiceBox(false);
        updateCheckBoxes();
        return ret.isPresent()? label.toString() : defaultStr;
    }

    private void updateCheckBoxes()
    {
        SelectionFigureSet set = getExtendedSelectionSet();
        for (FigureEffects effect : FigureEffects.values()){
            mainFrame.updateCheckBox(effect ,set.getEffectState(effect));
        }

    }

    private Optional<Figure> findFig(Point point, StringBuilder label)
    {
        Optional<Figure> ret = Optional.empty();
        for(Figure figure : figures()) {
            if(figure.contains(point) && figure.getActive()) {
                ret = Optional.of(figure);
                label.append(figure.toString());
            }
        }
        return ret;
    }



    public void moveFig(double diffX, double diffY){

        //moveGroup(getExtendedSelectionSet(),diffX,diffY);
        getExtendedSelectionSet().applyToSet(fig -> fig.move(diffX,diffY));
    }

    private SelectionFigureSet getExtendedSelectionSet()
    {
        SelectionFigureSet multSelectionExtended = new SelectionFigureSet(multSelectionFig);
        for (Figure fig:multSelectionFig) {
            if(fig.isGroupedFig())
            {
                multSelectionExtended.addAll(groupMap.findGroup(fig));
                multSelectionExtended.applyToSet(fig1 -> fig.setSelected(true));
            }
        }
        return multSelectionExtended;
        //capaz conviene que el multSelectionExtended sea una
        //variable de instancia asi no lo tenemos q estar creando constantemente
    }

    private void moveGroup(SelectionFigureSet multiSelectionExtended,double diffx,double diffY)
    {
        multiSelectionExtended.move(diffx,diffY);
    }

    public void group() {
        if(multSelectionFig.isEmpty() || multSelectionFig.onlyOne() || multSelectionFig.checkFigLayer()){return;}
        ungroup();
        Set<String> labels = new HashSet<>();
        SelectionFigureSet aux = new SelectionFigureSet();
        for (Figure fig:multSelectionFig) {
            if(!fig.isGroupedFig()) {
                aux.add(fig);
                fig.setGroupedFig(true);
                fig.setGroupNumber(groupNum);
                labels.addAll(fig.getLabelsList());

            }
        }
        groupMap.putIfAbsent(groupNum,aux);
        aux.applyToSet(fig -> fig.setLabels(labels.stream().toList()));
        groupNum++;
    }

    public void ungroup() {
        if (multSelectionFig.isEmpty()){return;}
        for (Figure fig : multSelectionFig) {
            if(fig.isGroupedFig()) {
                int groupN = fig.getGroupNumber();
                for (Figure figGrouped : groupMap.findGroup(fig)) {
                    figGrouped.setGroupedFig(false);
                    fig.setGroupNumber(0);
                }
                groupMap.remove(groupN);
            }
        }
    }

    public void rotAndScale(FigRotAndScale func)
    {
        //le paso a la interfaz funcional la funcion de fig que quiero que aplique
        //entonces aca solo con hacer func.apply(fig) llama a dicha funcion de fig que
        //le dije antes que aplique, no se si se entiende. lo llamo desde el mainFrame
        for (Figure fig : getExtendedSelectionSet()) {
           // fig.moveHorizontal();
            func.apply(fig);
        }
    }


    public void onlyOneLabel(TextArea textAreaDown) {
            String text = textAreaDown.getText();
            String[] parts = text.split("\\s+", 2);
            text = parts[0];
            for (Figure fig: figures()){
                boolean hasLabel = fig.hasLabel(text);
                fig.setActiveByLabelCheck(hasLabel);
            }
    }

    public void allLabels(){
        for(Figure figure: figures()){
            figure.setActiveByLabelCheck(true);
        }
    }

    public void changeActiveLayer(int newLayer) {
        //si llegamos a correr esto se supone que son todas de la misma layer
        Optional<Figure> firstFig = multSelectionFig.getFirstCustom();
        if(firstFig.isEmpty()){
            return; //no hay nada selected
        }
        int oldLayer = firstFig.get().getLayer();
        SelectionFigureSet set = getExtendedSelectionSet();
        figMap.moveToLayer(set,oldLayer, newLayer);

        //primero se llama a esto xq las figs saben en que layer
        //estaban y se pueden ubicar en el mapa facil.

        set.applyToSet(fig -> fig.setLayer(newLayer));
    }

}
