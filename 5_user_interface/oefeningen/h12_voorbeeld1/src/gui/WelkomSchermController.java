package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import java.io.IOException;

public class WelkomSchermController extends VBox {
    public WelkomSchermController() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("WelkomScherm.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
