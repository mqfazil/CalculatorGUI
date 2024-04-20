module org.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.calculator to javafx.fxml;
    exports org.example.calculator;
}