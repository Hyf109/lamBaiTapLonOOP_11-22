package com.example.demo;

import com.jfoenix.controls.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserButton {
    @FXML
    private Button Play;

    @FXML
    private Button Close;

    @FXML
    private Button Exit;



    private Stage stage;
    private Scene scene;
    private Parent parent;
    private FXMLLoader fxmlLoader;
    private JFXButton userButton1;
    private final String USERBUTTON_TAG = "#userButton";

    public UserButton(Scene scene) {
    userButton1 = (JFXButton) scene.lookup(USERBUTTON_TAG);
    this.stage= (Stage) (userButton1).getScene().getWindow();
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
            stage.close();

            newStage.setScene(scene);
            System.out.println("Hello");
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void showInformation() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User");
        alert.setHeaderText("The  function will be availble in next version!");
        alert.setContentText("You will be able to creat your own account!");
        alert.showAndWait();

    }

}
