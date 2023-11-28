package com.example.demo;

import com.jfoenix.controls.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameButton {

    private Scene scene;
    private JFXButton userButton1;
    private final String USERBUTTON_TAG = "#userButton";

    public GameButton(Scene scene) {
        userButton1 = (JFXButton) scene.lookup(USERBUTTON_TAG);
    }

    public void setUserButton() {
        userButton1.setOnMouseClicked(e -> {
//            showInformation();
            menu();
            System.out.println("WTF");
        });

    }

    public void menu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
            Stage newStage = new Stage();
            scene = new Scene(root);
            newStage.setScene(scene);
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
