package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ResultController {

    @FXML
    public Label marks, markstext, correcttext, wrongtext;

    @FXML
    public Label remark;


    @FXML
    public Button closeButton1, LeaderBoard1;

    @FXML
    public Button ReturnToMenu;

    @FXML
    public Button Retry;


    @FXML
    public Label Date;

    static String timeStamp = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(Calendar.getInstance().getTime());

    public void Retry(ActionEvent event) {
        try {
            for (int i = 0;i <=19; i++) {
                QuizController.checkStatus.set(i, false);
                QuizController.checkResult.set(i, false);
            }
            QuizController.fulltime = 100;
            QuizController.counter = 0;
            QuizController.correct = 0;
            QuizController.wrong = 0;
            Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            thisstage.close();
            FXMLLoader quiz = new FXMLLoader(getClass().getResource("Quiz.fxml"));
            Scene quizscene = new Scene(quiz.load());
            quizscene.setFill(Color.TRANSPARENT);
            Stage quizstage = new Stage();
            quizstage.setScene(quizscene);
            quizstage.initStyle(StageStyle.TRANSPARENT);
            quizstage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void ReturnToMenu(ActionEvent event) {
        try {
            for (int i = 0;i <=19; i++) {
                QuizController.checkStatus.set(i, false);
                QuizController.checkResult.set(i, false);
            }
            QuizController.fulltime = 100;
            QuizController.counter = 0;
            QuizController.correct = 0;
            QuizController.wrong = 0;
            Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            thisstage.close();
            FXMLLoader quiz = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Scene quizscene = new Scene(quiz.load());
            quizscene.setFill(Color.TRANSPARENT);
            Stage quizstage = new Stage();
            quizstage.setScene(quizscene);
            quizstage.initStyle(StageStyle.TRANSPARENT);
            quizstage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void handleCloseAction2() {
        Stage stage = (Stage) (closeButton1).getScene().getWindow();
        stage.close();
    }

    int correct;
    int wrong;
    int remainTime;

    public Label RemainTime;

    @FXML
    private void initialize() {
        for (int i = 0; i <= 19; i++) {
            if (QuizController.checkResult.get(i) && QuizController.checkStatus.get(i)) {
                QuizController.correct++;
            }
            if (!QuizController.checkResult.get(i) && QuizController.checkStatus.get(i)) {
                QuizController.wrong++;
            }
        }




        remainTime = QuizController.fulltime;
        RemainTime.setText("REMAIN TIME : " + String.valueOf(remainTime) + "S");
        timeStamp = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(Calendar.getInstance().getTime());
        Date.setText(timeStamp);
        correct = QuizController.correct;
        wrong = QuizController.wrong;

        correcttext.setText("Correct Answers : " + QuizController.correct);
        wrongtext.setText("Incorrect Answers : " + QuizController.wrong);

        marks.setText(correct * 5 + "/100");


        int completed = correct + wrong;
        markstext.setText(String.valueOf(completed) + " QUESTIONS COMPLETED");


        if (correct<4) {
            remark.setText("BAD !");
        } else if (correct < 10) {
            remark.setText("NEED MORE PRACTICE !");
        } else if (correct < 14) {
            remark.setText("QUITE GOOD !");
        } else if (correct < 18) {
            remark.setText("EXCELLENT !");
        } else if (correct <= 20) {
            remark.setText("WONDERFUL !");
        }


    }

}
