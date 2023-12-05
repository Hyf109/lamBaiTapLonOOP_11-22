package com.example.demo;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class GameController {
    @FXML
    private Button Play;

    @FXML
    private Button Close;

    @FXML
    private Button Exit;

    @FXML
    private Button Return;

    @FXML
    public void ReturnToMenu(ActionEvent event) {
        try {
            Stage thisStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            thisStage.close();
            Parent root = FXMLLoader.load(getClass().getResource("JavaFxTemp.fxml"));
            Scene scene = new Scene(root);
            Stage quizstage = new Stage();
            quizstage.setScene(scene);
            quizstage.setTitle("Dictionary");
            quizstage.show();
            Controller controller = new Controller();
            controller.init(scene);
            controller.initData();
            controller.hideSearchView(root);
            controller.addFunction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    private Stage stage;
    private Scene scene;
    private Parent parent;
    private FXMLLoader fxmlLoader;

    public void PlayGame(ActionEvent event) {
        try {
            Stage thisStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            thisStage.close();
            FXMLLoader quiz = new FXMLLoader(getClass().getResource("Quiz.fxml"));
            Scene quizscene = new Scene(quiz.load());
            quizscene.setFill(Color.TRANSPARENT);
            Stage quizStage = new Stage();
            quizStage.setScene(quizscene);
            quizStage.initStyle(StageStyle.TRANSPARENT);
            quizStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleCloseAction() {
        Stage stage = (Stage) (Exit).getScene().getWindow();
        stage.close();
    }

    public void initialize(URL location, ResourceBundle resources) throws IOException {
        Play.setOnAction(this::PlayGame);
    }

}
