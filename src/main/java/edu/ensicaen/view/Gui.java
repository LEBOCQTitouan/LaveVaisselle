package edu.ensicaen.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Gui {
    private static Gui instance = null;
    private GridPane stageGrid;

    private Button estimateButton;
    private Button showFuzzyInputMembershipFunctionsButton;
    private Button showOutputDefuzzifierFunctionButton;

    private TextField loadTextfield;
    private TextField amountOfDirtTextfield;
    private TextField waterHardnessTextfield;
    private TextField washingTimeTextfield;

    private Gui() {
        stageGrid = new GridPane();

        Label loadLabel = new Label("Charge du lave-vaisselle [%]: ");
        Label amountOfDirtLabel = new Label("Pourcentage de saleté [%]: ");
        Label waterHardnessLabel = new Label("Dureté de l'eau [dTH]: ");
        Label washingTimeLabel = new Label("Durée du lavage [min]: ");

        loadTextfield = new TextField();
        amountOfDirtTextfield = new TextField();
        waterHardnessTextfield = new TextField();
        washingTimeTextfield = new TextField();

        estimateButton = new Button("Estimer");
        showFuzzyInputMembershipFunctionsButton = new Button("Fonctions " + "d'appartenance en entrée");
        showOutputDefuzzifierFunctionButton = new Button("Fonction " + "d'appartenance en sortie");

        loadLabel.setPrefSize(200, 30);
        amountOfDirtLabel.setPrefSize(200, 30);
        waterHardnessLabel.setPrefSize(200, 30);
        washingTimeLabel.setPrefSize(200, 30);
        estimateButton.setPrefSize(300, 30);
        showFuzzyInputMembershipFunctionsButton.setPrefSize(300, 30);
        showOutputDefuzzifierFunctionButton.setPrefSize(300, 30);

        loadLabel.setAlignment(Pos.CENTER_RIGHT);
        amountOfDirtLabel.setAlignment(Pos.CENTER_RIGHT);
        waterHardnessLabel.setAlignment(Pos.CENTER_RIGHT);
        washingTimeLabel.setAlignment(Pos.CENTER_RIGHT);

        washingTimeTextfield.setEditable(false);

        stageGrid.setPadding(new Insets(10));
        stageGrid.setHgap(10);
        stageGrid.setVgap(10);

        stageGrid.addColumn(0, loadLabel, amountOfDirtLabel, waterHardnessLabel, showFuzzyInputMembershipFunctionsButton);
        stageGrid.addColumn(1, loadTextfield, amountOfDirtTextfield, waterHardnessTextfield);
        stageGrid.addColumn(2, washingTimeLabel, estimateButton);
        stageGrid.addColumn(3, washingTimeTextfield, showOutputDefuzzifierFunctionButton);


    }

    public Button getEstimateButton() {
        return estimateButton;
    }

    public Button getShowFuzzyInputMembershipFunctionsButton() {
        return showFuzzyInputMembershipFunctionsButton;
    }

    public Button getShowOutputDefuzzifierFunctionButton() {
        return showOutputDefuzzifierFunctionButton;
    }

    public static Gui getInstance() {
        if (instance == null) instance = new Gui();
        return instance;
    }

    public GridPane getStageGrid() {
        return stageGrid;
    }

    public TextField getLoadTextfield() {
        return loadTextfield;
    }

    public TextField getAmountOfDirtTextfield() {
        return amountOfDirtTextfield;
    }

    public TextField getWaterHardnessTextfield() {
        return waterHardnessTextfield;
    }

    public TextField getWashingTimeTextfield() {
        return washingTimeTextfield;
    }
}
