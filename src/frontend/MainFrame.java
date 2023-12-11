package frontend;

import backend.CanvasState;
import backend.model.Figure;
import backend.model.Point;
import frontend.Drawable.Drawable;
import javafx.scene.control.ColorPicker;
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

    public MainFrame() {
        canvasState = new CanvasState(this);
        statusPane = new StatusPane();
        //buttonManager = new ButtonManager(this);
        paintPane = new PaintPane_V2(statusPane,this);
        getChildren().add(new AppMenuBar());
        getChildren().add(paintPane);
        getChildren().add(statusPane);


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
        StringBuilder sb = new StringBuilder("Se selecciono");
        canvasState.getLabelSelectedText(eventPoint, sb);
        statusPane.updateStatus(sb.toString());
    }



    public void deleteFig()
    {
        canvasState.deleteFigure();
    }
}
