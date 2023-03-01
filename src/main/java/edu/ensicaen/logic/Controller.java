package edu.ensicaen.logic;

import edu.ensicaen.view.Gui;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class Controller {
    private static Gui gui;
    private GridPane grid;

    private FunctionBlock functionBlock;
    private Variable washingTime;

    public Controller() {
        gui = Gui.getInstance();
        grid = gui.getStageGrid();

        functionBlock = loadFisFile();

        gui.getEstimateButton().setOnAction(event -> calculateWashingTime());
    }

    private FunctionBlock loadFisFile() {
        String filename = getClass().getResource("/lave-vaisselle.fcl").toString();
        FIS fis = FIS.load(filename, true);

        if (fis == null) {
            System.err.println("Impossible de charger le fichier '" + filename + "'");
            System.exit(1);
        }
        return fis.getFunctionBlock(null);

    }

    private void showWashingTimeChart() {
        calculateWashingTime();
    }

    private void calculateWashingTime() {
        getInput();
        functionBlock.evaluate();
        washingTime = functionBlock.getVariable("dureeLavage");
        gui.getWashingTimeTextfield().setText(String.valueOf(washingTime.getValue()));
    }

    private void getInput() {
        double load;
        double amountOfDirt;
        double waterHardness;

        try {
            load = Double.parseDouble(gui.getLoadTextfield().getText());
            amountOfDirt = Double.parseDouble(gui.getAmountOfDirtTextfield().getText());
            waterHardness = Double.parseDouble(gui.getWaterHardnessTextfield().getText());

            checkBoundaries(load, 100);
            checkBoundaries(amountOfDirt, 100);
            checkBoundaries(waterHardness, 36);

            functionBlock.setVariable("charge", load);
            functionBlock.setVariable("niveauDeSalete", amountOfDirt);
            functionBlock.setVariable("dureteEau", waterHardness);

        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }

    private void checkBoundaries(double value, double high) {
        if (value < 0.0 || value > high)
            throw new IllegalArgumentException("Dépassement des bornes de l\'intervalle");
    }

    public GridPane getStageGrid() {
        return grid;
    }

}
