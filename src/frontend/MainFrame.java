package frontend;

import java.util.EnumMap;
import backend.CanvasState;
import backend.FigRotAndScale;
import backend.model.Figure;
import backend.model.FigureEffects;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.Buttons.EffectButtons.EffectsCheckBox;
import frontend.Drawable.Drawable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.List;

public class MainFrame extends VBox {

    Color lineColor = Color.BLACK;

    /* ToggleGroup tools = new ToggleGroup();
    ToggleButton selectionButton = new ToggleButton("Seleccionar");
    FigureButton rectangleButton = new RectangleButton(tools);
    FigureButton circleButton = new CircleButton(tools);
    FigureButton squareButton = new SquareButton(tools);
    FigureButton ellipseButton = new EllipseButton(tools);

    ToggleButton[] toolsArr  = {selectionButton, rectangleButton, circleButton, squareButton, ellipseButton};


     */
    Color defaultFillColor = Color.YELLOW;
    ColorPicker fillColorPicker = new ColorPicker(defaultFillColor);



    Label effectsLabel;
    EffectsCheckBox shadow;
    EffectsCheckBox belved;
    EffectsCheckBox gradient;

    private EnumMap<FigureEffects,EffectsCheckBox> effectsBoxMap;

   // List<EffectsCheckBox> effects;
    CanvasState canvasState;
    StatusPane statusPane;
    PaintPane_V2 paintPane;

    private HBox checkBox;
    private HBox checkBoxDown;

    public MainFrame() {
        canvasState = new CanvasState(this);
        statusPane = new StatusPane();
//        gradient = new CheckBox("gradient");
//        belved = new CheckBox("belved");
//        shadow = new CheckBox("Sombra");

       // effects = List.of(gradient,belved,shadow);
        effectsLabel = new Label("Efectos: ");
        //buttonManager = new ButtonManager(this);
        paintPane = new PaintPane_V2(statusPane,this,canvasState);
        gradient = new EffectsCheckBox("Gradient",FigureEffects.GRADIENT,paintPane, canvasState);
        belved = new EffectsCheckBox("Belved",FigureEffects.BELVED,paintPane, canvasState);
        shadow = new EffectsCheckBox("Shadow",FigureEffects.SHADOW,paintPane, canvasState);
        checkBox = createHBox();
        checkBoxDown = createHBoxDown();
        getChildren().add(new AppMenuBar());
        getChildren().add(checkBox);
        getChildren().add(paintPane);

        getChildren().add(checkBoxDown);
        getChildren().add(statusPane);

//        shadow.setOnAction(event -> {
//
//           // canvasState.shadow(shadow.isSelected());
//            canvasState.setEffect(FigureEffects.SHADOW,shadow.isSelected());
//            paintPane.reDraw();
//        });
//
//
//        belved.setOnAction(event -> {
//
//           // shadow.setIndeterminate(true);
//           // canvasState.belved(belved.isSelected());
//            canvasState.setEffect(FigureEffects.BELVED,belved.isSelected());
//            paintPane.reDraw();
//        });
//
//        gradient.setOnAction(event -> {
//
//           // canvasState.gradient(gradient.isSelected());
//            canvasState.setEffect(FigureEffects.GRADIENT,gradient.isSelected());
//            paintPane.reDraw();
//        });


    }

    public void updateCheckBox(FigureEffects effect,int state)
    {
        //si tienen ganas se podria hacer un enum que sea solo para los posibles estados
        //de las checkBoxes. en el switch en vez de usar -1, 0 , 1 usamos el enum
        //seria mas POO pero por ahora veamos q ande esto
        //lo tendriamos que tambien entonces actualizar en el SelectionFigureSet
        //cuando buscamos el estado de la checkBox
        
        EffectsCheckBox box = effectsBoxMap.get(effect);
        switch(state){
            case -1:
                box.setSelected(false);
                break;
            case 0:
                box.setIndeterminate(true);
                break;
            default:
                box.setSelected(true);
        }
    }



    private HBox createHBox()
    {
        HBox hbox = new HBox(10,effectsLabel,shadow,gradient,belved);// spacing = 8
        //capaz lo podemos cambiar y usar directamente el mapa
        effectsBoxMap = new EnumMap<>(FigureEffects.class);
        effectsBoxMap.put(FigureEffects.SHADOW,shadow);
        effectsBoxMap.put(FigureEffects.BELVED,belved);
        effectsBoxMap.put(FigureEffects.GRADIENT,gradient);
        hbox.setStyle("-fx-background-color: #999");
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefHeight(30);
        return hbox;
    }

    private HBox createHBoxDown()
    {
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: #999");
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefHeight(30);
        return hbox;
    }


    public void emptySelectedFig()
    {
        canvasState.emptySelectedFig();
        paintPane.reDraw();
    }


    public void drawFigure(Drawable figure)
    {
        canvasState.addFigure((Figure) figure);
        paintPane.drawFig(figure);
    }

    public void OnMouseMoved(Point eventPoint) {
        String label = canvasState.getLabelMouseMovedText(eventPoint);
        statusPane.updateStatus(label);
    }

    public void onMouseDragged(double diffX, double diffY){
        canvasState.moveFig(diffX,diffY);
    }

    public void selectFig(Point eventPoint)
    {
        StringBuilder sb = new StringBuilder("Se selecciono: ");
        statusPane.updateStatus(canvasState.onSingleSelect(eventPoint, sb));
       /* if(canvasState.getSelectedFigure().isPresent()){
            paintPane.getGc().setStroke(Color.RED);
        }
        */
        paintPane.reDraw();
    }

    public void biscelado()
    {
        //Set<Figure> set = canvasstate.getSelectedFigs();
        //foreach fig
        //fig.biscelar
    }
    public void biscelado2()
    {
        //canvasState.biscelado
    }


    public void selectFig(Rectangle selectionRect)
    {
        if(canvasState.getSelectedFigure().isPresent()){
            return;
        }
        canvasState.multipleSelection(selectionRect);
        paintPane.reDraw();
    }

    public void group()
    {
        canvasState.group();
    }

    public void ungroup()
    {
        canvasState.ungroup();
    }



    public void deleteFig()
    {
        canvasState.deleteFigure();
        paintPane.reDraw();
    }



    public void rotAndScale(CanvasStateRotAndScale func)
    {
       func.apply(canvasState);
       paintPane.reDraw();

       //cada boton llama a rotAndScale del mainFrame con una interfaz funcional que pide
        //una funcion del canvasState para hacer apply
        //la funcion en cuestion es siempre rotAndScale de canvasState pero le cambio el parametro
        //(la interfaz funcional que toma rotAndScale de canvas state es diferente)
    }

    public void rotateH() {
        //canvasState.rotateH();


        canvasState.rotAndScale(fig -> fig.moveHorizontal()); //can be replaced with method reference
        // pero para no confundirnos lo dejo asi.

        //le estoy diciendo que cuando haga el apply(fig) a la interfaz funcional
        //que haga fig.moveHorizontal
        //lo mismo con las otras pero cada una con su respectiva funcion

        //termine usando la funcion de arriba porque podemos hacer lo mismo que hacemos con el canvas state
        //pero tambien con el mainFrame entonces queda como una composicion medio rara, pero estas
        //funciones son mas faciles de entender primero


        paintPane.reDraw(); //agregue esto porque sino esperaba a la proxima para hacerlo
    }

    public void rotateV() {
       // canvasState.rotateV();
        canvasState.rotAndScale(fig -> fig.moveVertical());
        paintPane.reDraw();
    }

    public void turnR(){
        canvasState.rotAndScale(fig -> fig.turnR());
        paintPane.reDraw();
    }

    public void scaleUp(){
        //canvasState.scaleUp();
        canvasState.rotAndScale(fig -> fig.scaleUp());
        paintPane.reDraw();
    }

    public void scaleDown() {
        //canvasState.scaleDown();
        canvasState.rotAndScale(fig -> fig.scaleDown());
        paintPane.reDraw();
    }
}
