package frontend;

import backend.CanvasState;
import backend.model.Figure;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.Drawable.Drawable;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
    CheckBox shadow;
    CheckBox belved;
    CheckBox gradient;
    CanvasState canvasState;
    StatusPane statusPane;
    PaintPane_V2 paintPane;

    private HBox checkBox;

    public MainFrame() {
        canvasState = new CanvasState(this);
        statusPane = new StatusPane();
        gradient = new CheckBox("gradient");
        belved = new CheckBox("belved");
        shadow = new CheckBox("Sombra");
        effectsLabel = new Label("Efectos: ");
        //buttonManager = new ButtonManager(this);
        paintPane = new PaintPane_V2(statusPane,this,canvasState);
        checkBox = createHBox();
        getChildren().add(new AppMenuBar());
        getChildren().add(checkBox);
        getChildren().add(paintPane);
        getChildren().add(statusPane);

        shadow.setOnAction(event -> {

            canvasState.shadow(shadow.isSelected());
            paintPane.reDraw();
        });


        belved.setOnAction(event -> {

           // shadow.setIndeterminate(true);
            canvasState.belved(belved.isSelected());
            paintPane.reDraw();
        });

        gradient.setOnAction(event -> {

            canvasState.gradient(gradient.isSelected());
            paintPane.reDraw();
        });


    }



    private HBox createHBox()
    {
        HBox hbox = new HBox(10,effectsLabel,shadow,gradient,belved);// spacing = 8
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

    public void updateCheckBoxes(int shadowInt, int belved, int gradient) {

    }

    public void updateShadowBox(boolean activated) {
        shadow.setSelected(activated);
    }
    public void updateShadowBox()
    {
        shadow.setIndeterminate(true);
    }

    public void rotateH() {
        canvasState.rotateH();
        paintPane.reDraw(); //agregue esto porque sino esperaba a la proxima para hacerlo
    }

    public void rotateV() {
        canvasState.rotateV();
        paintPane.reDraw();
    }
}
