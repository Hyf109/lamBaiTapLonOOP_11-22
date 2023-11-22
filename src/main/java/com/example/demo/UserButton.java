package com.example.demo;

import com.jfoenix.controls.*;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

public class UserButton {
    private JFXButton userButton1;
    private final String USERBUTTON_TAG = "#userButton";

    public UserButton(Scene scene) {
    userButton1 = (JFXButton) scene.lookup(USERBUTTON_TAG);
    }

    public void setUserButton() {
        userButton1.setOnMouseClicked(e -> {
            showInformation();
            System.out.println("WTF");
        });

    }

    public void showInformation() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User");
        alert.setHeaderText("The  function will be availble in next version!");
        alert.setContentText("You will be able to creat your own account!");
        alert.showAndWait();

    }

}
