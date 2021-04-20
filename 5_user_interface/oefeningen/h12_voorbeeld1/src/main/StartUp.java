package main;

import gui.WelkomSchermController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        WelkomSchermController root = new WelkomSchermController();
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Welkom!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
