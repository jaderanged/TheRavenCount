module com.example.javafxpractice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires org.junit.jupiter.api;

    opens com.example.javafxpractice to javafx.fxml;
    exports com.example.javafxpractice;
}