package frontend;

import backend.CanvasState;
import frontend.Buttons.*;
import frontend.Buttons.FigureButton;
import backend.model.Figure;
import backend.model.Point;
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
    private final CanvasState canvasState;
    // StatusBar
    private StatusPane statusPane;
    private final MainFrame mainFrame;
    private final ToggleGroup tools = new ToggleGroup();
    private DeleteButton deleteButton;
    private GroupButton groupButton;
    private UnGroup unGroupButton;
    private RotateH rotateH;
    private TurnR turnR;
    private RotateV rotateV;
    private ScaleUp scaleUp;
    private ScaleDown scaleDown;
    private SaveButton saveButton;
    private TextArea txtArea;
    private ArrayList<ToggleButton> toolsArr;
    private ToggleButton[] arr;
    private final int MINHELDFRAMES = 10;
    private VBox buttonBox;
    private ChoiceBox<Layer> layerBox;



    public PaintPane_V2(StatusPane statusPane, MainFrame mainFrame,CanvasState canvasState)
    {
        this.mainFrame = mainFrame;
        this.statusPane = statusPane;
        this.canvasState = canvasState;
        deleteButton = new DeleteButton(tools,mainFrame);
        SelectButton selectionButton = new SelectButton(tools, mainFrame);
        FigureButton rectangleButton = new RectangleButton(tools, mainFrame, gc);
        FigureButton circleButton = new CircleButton(tools, mainFrame, gc);
        FigureButton squareButton = new SquareButton(tools, mainFrame, gc);
        FigureButton ellipseButton = new EllipseButton(tools, mainFrame, gc);
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
        toolsArr = new ArrayList<>();
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
        setLeft(buttonBox);

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
            getCurrentButton().onMouseRelease(startPoint,
                    endPoint,
                    fillColorPicker.getValue(),
                    mainFrame.getEffectsBooleanMap(),
                    layerBox.getValue().getValue());
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
            mainFrame.applyToSelected(canvasState1 -> canvasState1.moveFig(diffX,diffY));

        });

    }

    public TextArea getTxtArea(){
        return txtArea;
    }
    public ChoiceBox<Layer> getLayerBox() {
        return layerBox;
    }

    public SaveButton getSaveButton(){
        return saveButton;
    }


    public void reDraw()
    {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (Figure fig:canvasState.figures()) {
            fig.draw();
            gc.setStroke(lineColor);
        }
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
        buttonsBox.getChildren().add(new Label("Layers: "));
        layerBox.getItems().addAll(new Layer(1),new Layer(2),new Layer(3));
        layerBox.setValue(new Layer(1));
        buttonsBox.getChildren().add(layerBox);
        layerBox.setOnAction(event -> {canvasState.changeActiveLayer(layerBox.getValue().getValue());
        reDraw();
        });

        txtArea.setMaxHeight(55);
        Label label = new Label("Etiquetas:");
        buttonsBox.getChildren().add(label);
        buttonsBox.getChildren().add(txtArea);
        buttonsBox.getChildren().add(saveButton);
        return buttonsBox;
    }




}
