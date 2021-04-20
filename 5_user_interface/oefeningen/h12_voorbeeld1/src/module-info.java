module h12_voorbeeld1 {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.base;
    requires javafx.fxml;

    opens main to javafx.graphics, javafx.fxml;
}