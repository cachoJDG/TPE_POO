package frontend;

import java.util.EnumMap;
import backend.CanvasState;
import backend.CheckBoxState;
import backend.model.Figure;
import backend.model.FigureEffects;
import backend.model.Point;
import backend.model.Rectangle;
import frontend.Buttons.EffectButtons.EffectsCheckBox;
import frontend.Buttons.EffectButtons.LayerCheckBox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainFrame extends VBox {

    Label effectsLabel;
    EffectsCheckBox shadow;
    EffectsCheckBox belved;
    EffectsCheckBox gradient;

    TextArea textAreaDown;
    RadioButton allLabelButton;
    RadioButton onlyOneLabelButton;

    ToggleGroup labelGroup = new ToggleGroup();

    private EnumMap<FigureEffects, EffectsCheckBox> effectsBoxMap;

    CanvasState canvasState;
    StatusPane statusPane;
    PaintPane_V2 paintPane;

    private HBox checkBox;
    private HBox checkBoxDown;

    private HBox checkBoxLayer;

    LayerCheckBox layer1;
    LayerCheckBox layer2;
    LayerCheckBox layer3;

    public MainFrame() {


        canvasState = new CanvasState(this);
        statusPane = new StatusPane();
        effectsLabel = new Label("Efectos: ");
        paintPane = new PaintPane_V2(statusPane, this, canvasState);
        gradient = new EffectsCheckBox("Gradient", FigureEffects.GRADIENT, paintPane, canvasState);
        belved = new EffectsCheckBox("Belved", FigureEffects.BELVED, paintPane, canvasState);
        shadow = new EffectsCheckBox("Shadow", FigureEffects.SHADOW, paintPane, canvasState);
        layer1 = new LayerCheckBox("Layer 1", paintPane, canvasState, 1);
        layer2 = new LayerCheckBox("Layer 2", paintPane, canvasState, 2);
        layer3 = new LayerCheckBox("Layer 3", paintPane, canvasState, 3);
        checkBox = createHBox();
        checkBoxDown = createHBoxDown();
        checkBoxLayer = createHBoxLayers();
        getChildren().add(new AppMenuBar());
        getChildren().add(checkBox);
        getChildren().add(paintPane);
        getChildren().add(checkBoxLayer);
        getChildren().add(checkBoxDown);
        getChildren().add(statusPane);

    }

    public boolean layerActive(int layer) {
        for (Node n : checkBoxLayer.getChildren()) {
            LayerCheckBox box = (LayerCheckBox) n;
            if (box.getLayer() == layer) {
                return box.isSelected();
            }
        }
        throw new IllegalStateException("Layer " + layer + " Not found");
    }

    public void updateCheckBox(FigureEffects effect, CheckBoxState state) {
        EffectsCheckBox box = effectsBoxMap.get(effect);
        switch (state) {
            case NOTSELECTED:
                box.setIndeterminate(false);
                box.setSelected(false);
                break;
            case UNDEFINED:
                box.setIndeterminate(true);
                break;
            default:
                box.setIndeterminate(false);
                box.setSelected(true);
        }
    }

    public EnumMap<FigureEffects, Boolean> getEffectsBooleanMap() {
        EnumMap<FigureEffects, Boolean> map = new EnumMap<>(FigureEffects.class);
        for (FigureEffects effects : FigureEffects.values()) {
            Boolean state = effectsBoxMap.get(effects).isSelected();
            map.put(effects, state);
        }
        return map;
    }


    private HBox createHBox() {
        HBox hbox = new HBox(10, effectsLabel, shadow, gradient, belved);// spacing = 8
        //capaz lo podemos cambiar y usar directamente el mapa
        effectsBoxMap = new EnumMap<>(FigureEffects.class);
        effectsBoxMap.put(FigureEffects.SHADOW, shadow);
        effectsBoxMap.put(FigureEffects.BELVED, belved);
        effectsBoxMap.put(FigureEffects.GRADIENT, gradient);
        hbox.setStyle("-fx-background-color: #999");
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefHeight(5); //lo cambie a 5 xq sino no me entra en la pantalla
        return hbox;
    }

    private HBox createHBoxLayers() {
        HBox hbox = new HBox();

        hbox.getChildren().add(layer1);
        hbox.getChildren().add(layer2);
        hbox.getChildren().add(layer3);
        hbox.setStyle("-fx-background-color: #999");
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefHeight(30);
        return hbox;
    }

    private HBox createHBoxDown() {
        HBox hbox = new HBox();
        textAreaDown = new TextArea();

        textAreaDown.setMaxWidth(170);

        allLabelButton = new RadioButton("Todas: ");
        onlyOneLabelButton = new RadioButton("Sólo: ");
        allLabelButton.setToggleGroup(labelGroup);
        onlyOneLabelButton.setToggleGroup(labelGroup);

        allLabelButton.setOnAction(event -> {
            canvasState.allLabels();
            paintPane.reDraw();
        });

        onlyOneLabelButton.setOnAction(event -> {
            canvasState.onlyOneLabel(textAreaDown);
            paintPane.reDraw();
        });
        Label label = new Label("Mostrar Etiquetas: ");

        hbox.getChildren().add(label);
        hbox.getChildren().add(allLabelButton);
        hbox.getChildren().add(onlyOneLabelButton);
        hbox.setPadding(new Insets(10));
        hbox.getChildren().add(textAreaDown);
        hbox.setStyle("-fx-background-color: #999");
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefHeight(30);
        return hbox;
    }


    public void emptySelectedFig() {
        canvasState.emptySelectedFig();
        paintPane.reDraw();
    }

    public void OnMouseMoved(Point eventPoint) {
        String label = canvasState.getLabelMouseMovedText(eventPoint);
        statusPane.updateStatus(label);
    }

    public void selectFig(Point eventPoint) {
        StringBuilder sb = new StringBuilder("Se selecciono: ");
        statusPane.updateStatus(canvasState.onSingleSelect(eventPoint, sb));
       /* if(canvasState.getSelectedFigure().isPresent()){
            paintPane.getGc().setStroke(Color.RED);
        }
        */
        paintPane.reDraw();
    }


    public void selectFig(Rectangle selectionRect) {
        if (canvasState.getSelectedFigure().isPresent()) {
            return;
        }
        canvasState.multipleSelection(selectionRect);
        paintPane.reDraw();
    }


    //Diego me fui a duchar Saludos!
    public void UpdateTextArea(boolean activated, String text) {
        paintPane.txtArea.setDisable(activated);

        paintPane.getSaveButton().setDisable(activated);
        if (!activated) {
            paintPane.txtArea.setText(text);
        }
    }


    public void rotAndScale(CanvasStateRotAndScale func) {
        func.apply(canvasState);
        paintPane.reDraw();

        //cada boton llama a rotAndScale del mainFrame con una interfaz funcional que pide
        //una funcion del canvasState para hacer apply
        //la funcion en cuestion es siempre rotAndScale de canvasState pero le cambio el parametro
        //(la interfaz funcional que toma rotAndScale de canvas state es diferente)
    }


    public void UpdateChoiceBox(boolean active) {
        paintPane.layerBox.setDisable(active);
    }

}
