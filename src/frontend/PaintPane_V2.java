package frontend;

import backend.CanvasState;
import backend.model.FigureEffects;
import frontend.Buttons.*;
import frontend.Buttons.FigureButton;
import backend.model.Figure;
import backend.model.Point;
import frontend.Drawable.Drawable;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.*;

public class PaintPane_V2 extends BorderPane {

    private final Canvas canvas = new Canvas(800, 600);
    private final GraphicsContext gc = canvas.getGraphicsContext2D();
    private final Color lineColor = Color.BLACK;
    private final Color defaultFillColor = Color.YELLOW;
    private int framesHeld;
    private final ColorPicker fillColorPicker = new ColorPicker(defaultFillColor);


    // Dibujar una figura
    private Point startPoint;

    // Seleccionar una figura
    private Figure selectedFigure;

    private final CanvasState canvasState;
    // StatusBar
    private StatusPane statusPane;

    private final MainFrame mainFrame;

    private final ToggleGroup tools = new ToggleGroup();
    private SelectButton selectionButton;
    private FigureButton rectangleButton;
    private FigureButton circleButton;
    private FigureButton squareButton;
    private FigureButton ellipseButton;
    DeleteButton deleteButton;
    GroupButton groupButton;
    UnGroup unGroupButton;
    RotateH rotateH;

    TurnR turnR;
    RotateV rotateV;
    ScaleUp scaleUp;
    ScaleDown scaleDown;

    SaveButton saveButton;
    TextArea txtArea;

    ArrayList<ToggleButton> toolsArr;

    ToggleButton[] arr;

    private final int MINHELDFRAMES = 10;
    VBox buttonBox;
    ChoiceBox<String> layerBox;

    Map<Figure, Color> figureColorMap = new HashMap<>();


    public PaintPane_V2(StatusPane statusPane, MainFrame mainFrame,CanvasState canvasState)
    {


        this.mainFrame = mainFrame;
        this.statusPane = statusPane;
        this.canvasState = canvasState;
        deleteButton = new DeleteButton(tools,mainFrame);
        selectionButton = new SelectButton(tools,mainFrame);
        rectangleButton = new RectangleButton(tools,mainFrame, gc);
        circleButton = new CircleButton(tools,mainFrame, gc);
        squareButton = new SquareButton(tools,mainFrame, gc);
        ellipseButton = new EllipseButton(tools,mainFrame, gc);
        groupButton = new GroupButton(tools,mainFrame);
        unGroupButton = new UnGroup(tools, mainFrame);
        rotateH = new RotateH(tools, mainFrame);
        rotateV = new RotateV(tools, mainFrame);
        turnR = new TurnR(tools, mainFrame);
        scaleUp = new ScaleUp(tools, mainFrame);
        scaleDown = new ScaleDown(tools, mainFrame);
        txtArea = new TextArea();
        saveButton = new SaveButton(tools, mainFrame, txtArea);
        layerBox = new ChoiceBox<>();
        arr = new ToggleButton[]{selectionButton, rectangleButton, circleButton, squareButton, ellipseButton, circleButton, deleteButton, groupButton, unGroupButton
                , rotateH, rotateV, turnR, scaleUp, scaleDown};

        toolsArr = new ArrayList<ToggleButton>();
//        toolsArr.addAll(List.of(selectionButton,rectangleButton,circleButton,squareButton,ellipseButton, circleButton, deleteButton, groupButton, unGroupButton
//                , rotateH, rotateV, turnR, scaleUp, scaleDown));
//        toolsArr.addAll( rectangleButton, squareButton);

//        toolsArr.addAll(List.of(arr));

        toolsArr.add(selectionButton);
        toolsArr.add(rectangleButton);
        toolsArr.add(squareButton);
        toolsArr.add(ellipseButton);
        toolsArr.add(circleButton);
        toolsArr.add(deleteButton);
        toolsArr.add(groupButton);
        toolsArr.add(unGroupButton);
        toolsArr.add(rotateH);
        toolsArr.add(rotateV);
        toolsArr.add(turnR);
        toolsArr.add(scaleUp);
        toolsArr.add(scaleDown);
        gc.setLineWidth(1);
        setRight(canvas);
        buttonBox = createButtonBox();
        setLeft(buttonBox); //dsp vemos




        canvas.setOnMousePressed(event -> {
            startPoint = new Point(event.getX(), event.getY());
            framesHeld = 0;
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
            getCurrentButton().onMouseRelease(startPoint,endPoint,fillColorPicker.getValue(),mainFrame.getEffectsBooleanMap());
            //dibujar
        });


        canvas.setOnMouseMoved(event -> {
            Point eventPoint = new Point(event.getX(), event.getY());
            mainFrame.OnMouseMoved(eventPoint);
        });


        canvas.setOnMouseClicked(event -> {
            if(framesHeld > MINHELDFRAMES){
                return;
            }
            Point eventPoint = new Point(event.getX(), event.getY());
            getCurrentButton().onMouseClicked(eventPoint);

        });


        canvas.setOnMouseDragged(event -> {
            framesHeld++;
            Point eventPoint = new Point(event.getX(), event.getY());
            double diffX = (eventPoint.getX() - startPoint.getX()) / 100;
            double diffY = (eventPoint.getY() - startPoint.getY()) / 100;
            mainFrame.onMouseDragged(diffX, diffY);
           reDraw();
        });

    }

    public SaveButton getSaveButton(){
        return saveButton;
    }


    public void reDraw()
    {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Figure fig:canvasState.figures()) {
//            if(canvasState.getSelectedFigure().isPresent()) {
//                if (canvasState.getSelectedFigure().get().equals(fig)) {
//                    gc.setStroke(Color.RED);
//                } else {
//                    gc.setStroke(lineColor);
//                }
//            }
            Drawable drawable = (Drawable)fig;
            drawable.draw();
            gc.setStroke(lineColor);
        }
    }


    public void drawFig(Drawable figure)
    {
        figure.draw();
    }

    public GraphicsContext getGc() {
        return gc;
    }

    public ToolButton getCurrentButton()
    {
        ToolButton aux = (ToolButton)tools.getSelectedToggle();
        if(aux == null){
            return new DefaultBtn(tools,mainFrame);
        }
        return aux;
    }


    private VBox createButtonBox()
    {
        VBox buttonsBox = new VBox(10);
        buttonsBox.getChildren().addAll(toolsArr);
        buttonsBox.getChildren().add(fillColorPicker);
        buttonsBox.setPadding(new Insets(5));
        buttonsBox.setStyle("-fx-background-color: #999");
        buttonsBox.setPrefWidth(100);
        layerBox.getItems().addAll("Layer 1", "Layer 2", "Layer 3");
        layerBox.setValue("Layer 1");
        buttonsBox.getChildren().add(layerBox);


        // lo ultimo
        txtArea.setMaxHeight(55);
        Label label = new Label("Etiquetas:");
        buttonsBox.getChildren().add(label);
        buttonsBox.getChildren().add(txtArea);
        buttonsBox.getChildren().add(saveButton);
        return buttonsBox;
    }




}
