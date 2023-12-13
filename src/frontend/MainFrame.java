package frontend;

import backend.CanvasState;
import backend.model.Figure;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.Drawable.Drawable;
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



    CanvasState canvasState;
    StatusPane statusPane;
    PaintPane_V2 paintPane;

    private HBox checkBox;

    public MainFrame() {
        canvasState = new CanvasState(this);
        statusPane = new StatusPane();
        //buttonManager = new ButtonManager(this);
        paintPane = new PaintPane_V2(statusPane,this,canvasState);
        checkBox = createHBox();
        getChildren().add(new AppMenuBar());
        getChildren().add(checkBox);
        getChildren().add(paintPane);
        getChildren().add(statusPane);



    }

    private HBox createHBox()
    {
        HBox hbox = new HBox(8); // spacing = 8
        hbox.getChildren().addAll(new Label("Name:"), new TextField());
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
        statusPane.updateStatus(canvasState.getLabelSelectedText(eventPoint, sb));
       /* if(canvasState.getSelectedFigure().isPresent()){
            paintPane.getGc().setStroke(Color.RED);
        }
        */
        paintPane.reDraw();
    }

    public void selectFig(Rectangle selectionRect)
    {
        canvasState.multipleSelection(selectionRect);
        paintPane.reDraw();
    }





    public void deleteFig()
    {
        canvasState.deleteFigure();
        paintPane.reDraw();
    }
}
