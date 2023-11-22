module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.web;
    requires freetts;
    requires com.jfoenix;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}