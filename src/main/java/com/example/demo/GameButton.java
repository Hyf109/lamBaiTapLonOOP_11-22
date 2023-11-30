package com.example.demo;

import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameButton {

    private Scene scene;
    private JFXButton userButton1;
    private final String USERBUTTON_TAG = "#userButton";

    public GameButton(Scene scene) {
        userButton1 = (JFXButton) scene.lookup(USERBUTTON_TAG);
    }






//    public void showInformation() {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("User");
//        alert.setHeaderText("The  function will be availble in next version!");
//        alert.setContentText("You will be able to creat your own account!");
//        alert.showAndWait();
//
//    }

}
