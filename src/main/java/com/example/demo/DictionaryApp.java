package com.example.demo;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DictionaryApp extends Application {
    private static final String FXML_FILE_PATH = "JavaFxTemp.fxml";
    private static Controller controller = new Controller();
    private Dictionary dic = new Dictionary();
    private HistorySearch his = new HistorySearch();

    public static void main(String[] args) {
        Application.launch(args);
    }



    @FXML
    private JFXButton game;

    @FXML
    public void menu(ActionEvent event) {
        try {
            Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            thisstage.close();
            FXMLLoader menu = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Scene quizscene = new Scene(menu.load());
            quizscene.setFill(Color.TRANSPARENT);
            Stage quizstage = new Stage();
            quizstage.setScene(quizscene);
            quizstage.initStyle(StageStyle.TRANSPARENT);
            quizstage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(FXML_FILE_PATH));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Dictionary");
        primaryStage.show();

        controller.init(scene);
        controller.initData();
        controller.hideSearchView(root);
        controller.addFunction();

    }

    @Override
    public void stop() throws Exception {
        super.stop();
        if (controller.getChanged()) {
            his.saveHistory();
            dic.exportToFile();
            System.out.println("Save changed");
        } else {
            System.out.println("nothing changed");
        }

    }
}
