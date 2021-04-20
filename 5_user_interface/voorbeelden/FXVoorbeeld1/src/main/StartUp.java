package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import gui.WelkomScherm;

// hoofdklasse => subklasse van Application
public class StartUp extends Application {

    /**
     * uitvoeren applicatie
     * @param primaryStage - hoofdVenster
     */
    @Override
    public void start(Stage primaryStage) {
        WelkomScherm root = new WelkomScherm();
        // maak Scene op basis van het hoofdpaneel en een gewenste grootte
        Scene scene = new Scene(root, 500, 300);

        // koppel Scene aan de Stage (het venster).
        primaryStage.setScene(scene);

        // titel aan het venster en tonen we het op het scherm.
        primaryStage.setTitle("Welkom bij JavaFX");
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
