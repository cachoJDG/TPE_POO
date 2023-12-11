package frontend;

import backend.Buttons.*;
import backend.Buttons.FigureButton;
import backend.CanvasState;
import backend.model.Figure;
import backend.Buttons.*;
import backend.model.Point;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class PaintPane_V2 extends BorderPane {

    Canvas canvas = new Canvas(800, 600);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    Color lineColor = Color.BLACK;
    Color defaultFillColor = Color.YELLOW;

    ColorPicker fillColorPicker = new ColorPicker(defaultFillColor);

    // Dibujar una figura
    Point startPoint;

    // Seleccionar una figura
    Figure selectedFigure;

    // StatusBar
    StatusPane statusPane;

    MainFrame mainFrame;

    ToggleGroup tools = new ToggleGroup();
    ToggleButton selectionButton = new ToggleButton("Seleccionar");
    FigureButton rectangleButton = new RectangleButton(tools,mainFrame);
    FigureButton circleButton = new CircleButton(tools,mainFrame);
    FigureButton squareButton = new SquareButton(tools,mainFrame);
    FigureButton ellipseButton = new EllipseButton(tools,mainFrame);

    ToggleButton[] toolsArr  = {selectionButton, rectangleButton, circleButton, squareButton, ellipseButton};

    VBox buttonBox;

    Map<Figure, Color> figureColorMap = new HashMap<>();


    public PaintPane_V2(StatusPane statusPane, MainFrame mainFrame)
    {
        this.mainFrame = mainFrame;
        this.statusPane = statusPane;
        gc.setLineWidth(1);
        setRight(canvas);
        buttonBox = createButtonBox();
        setLeft(buttonBox); //dsp vemos

        canvas.setOnMousePressed(event -> {
            startPoint = new Point(event.getX(), event.getY());
        });

        canvas.setOnMouseReleased(event -> {

            Point endPoint = new Point(event.getX(), event.getY());
            if (startPoint == null) {
                return;
            }
            if (endPoint.getX() < startPoint.getX() || endPoint.getY() < startPoint.getY()) {
                return;
            }

            //fireEvent(new CustomOne(CustomOne.MOUSE_REL)); era para probar eventos custom, no lo use
            getCurrentButton().onMouseRelease(startPoint,endPoint);
            //dibujar
        });


        canvas.setOnMouseMoved(event -> {
            Point eventPoint = new Point(event.getX(), event.getY());
            mainFrame.OnMouseMoved(eventPoint);
        });

        canvas.setOnMouseClicked(event -> {
            Point eventPoint = new Point(event.getX(), event.getY());
            getCurrentButton().onMouseClicked(eventPoint);
        });

        canvas.setOnMouseDragged(event -> {
            Point eventPoint = new Point(event.getX(), event.getY());
            double diffX = (eventPoint.getX() - startPoint.getX()) / 100;
            double diffY = (eventPoint.getY() - startPoint.getY()) / 100;
            mainFrame.onMouseDragged(diffX, diffY);
            //redrawCanvas();
        });

    }



    public ToolButton getCurrentButton()
    {
        return (ToolButton)tools.getSelectedToggle();
    }


    private VBox createButtonBox()
    {
        VBox buttonsBox = new VBox(10);
        buttonsBox.getChildren().addAll(toolsArr);
        buttonsBox.getChildren().add(fillColorPicker);
        buttonsBox.setPadding(new Insets(5));
        buttonsBox.setStyle("-fx-background-color: #999");
        buttonsBox.setPrefWidth(100);
        return buttonsBox;
    }
}
