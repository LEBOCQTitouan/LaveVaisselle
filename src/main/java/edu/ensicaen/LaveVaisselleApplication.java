package edu.ensicaen;

import edu.ensicaen.logic.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LaveVaisselleApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lave-vaiselle \"flou\"");
        primaryStage.setScene(new Scene(new Controller().getStageGrid(), 800, 150));
        primaryStage.show();
    }
}
