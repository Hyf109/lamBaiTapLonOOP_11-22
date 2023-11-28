package com.example.demo;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class QuizController {
    @FXML
    public Button A, B, C, D, closeButton;
    @FXML
    public Label Question;

    public static List<Boolean> checkResult = new ArrayList<>(100);


    public void handleCloseAction1() {
        Stage stage = (Stage) (closeButton).getScene().getWindow();
        stage.close();
    }


    /**
     * .
     */
    @FXML
    private void initialize() throws IndexOutOfBoundsException {
        try {

            loadQuestion();
            loadOpt();
            loadAns();


            setStatus();
            loadResult();
            loadTime();
            loadQuiz();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    static int fullTime = 100;
    public Timeline timeline = new Timeline();

    private void loadTime() {

        TimeRemain.setText(String.valueOf(fullTime));
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            fullTime--;
            TimeRemain.setText(String.valueOf(fullTime));
        }));
        timeline.setCycleCount(fullTime);
        timeline.play();
        timeline.setOnFinished(e -> {
            try {
                Stage stage;
                stage = (Stage) TimeRemain.getScene().getWindow();
                stage.close();
                FXMLLoader quiz = new FXMLLoader(getClass().getResource("Result.fxml"));
                Scene quizscene = new Scene(quiz.load());
                quizscene.setFill(Color.TRANSPARENT);
                Stage quizstage = new Stage();
                quizstage.setScene(quizscene);
                quizstage.initStyle(StageStyle.TRANSPARENT);
                quizstage.show();
            } catch (IOException f) {
                f.printStackTrace();
            }
        });
    }


    /**
     * Lay du lieu cau hoi tu file.
     */
    private static final String QUES = "./file/Question.txt";
    private static final List<String> QuesTest = new ArrayList<>();
    static short counter = 0;
    static int correct = 0;
    static int wrong = 0;


    public void loadQuestion() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(QUES));
        String line = br.readLine();
        while (line != null) {
            QuesTest.add(line);
            line = br.readLine();
        }
    }


    /**
     * Lay du lieu A, B, C, D tu file.
     */

    private static final String Opt = "./file/Option.txt";
    private static final List<String> OptTest = new ArrayList<>();

    public void loadOpt() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(Opt));
        String line = br.readLine();
        while (line != null) {
            OptTest.add(line);
            line = br.readLine();
        }

    }


    /**
     * Lay du lieu answer tu file.
     */

    private static final String Ans = "./file/Answer.txt";
    private static final List<String> AnsTest = new ArrayList<>();

    public void loadAns() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(Ans));
        String line = br.readLine();
        while (line != null) {
            AnsTest.add(line);
            line = br.readLine();
        }

    }


    /**
     * Tao cau hoi.
     */
    public int[] cards = ThreadLocalRandom.current().ints(0, 109).distinct().limit(20).toArray();

    private void loadQuiz() {
        Question.setText("Question " + (counter + 1) + " : " + QuesTest.get(cards[counter]));
        A.setText(OptTest.get(4 * cards[counter]));
        B.setText(OptTest.get(4 * cards[counter] + 1));
        C.setText(OptTest.get(4 * cards[counter] + 2));
        D.setText(OptTest.get(4 * cards[counter] + 3));
    }

    /**
     * .
     */
    boolean checkAnswer(String Answer) {
        return Answer.equals(AnsTest.get(cards[counter]));
    }

    @FXML
    public void AClicked() {
        checkStatus.set(counter, true);
        checkAnswer(A.getText());
        checkResult.set(counter, checkAnswer(A.getText()));
        fillColor();
        if (counter < 19) {
            counter++;
            loadQuiz();
        }
    }

    @FXML
    public void BClicked() {
        checkStatus.set(counter, true);
        checkAnswer(B.getText());
        checkResult.set(counter, checkAnswer(B.getText()));
        fillColor();
        if (counter < 19) {
            counter++;
            loadQuiz();
        }
    }

    @FXML
    public void CClicked() {
        checkStatus.set(counter, true);
        checkAnswer(C.getText());
        checkResult.set(counter, checkAnswer(C.getText()));
        fillColor();
        if (counter < 19) {
            counter++;
            loadQuiz();
        }
    }

    @FXML
    public void DClicked() {
        checkStatus.set(counter, true);
        checkAnswer(D.getText());
        checkResult.set(counter, checkAnswer(D.getText()));
        fillColor();
        if (counter < 19) {
            counter++;
            loadQuiz();
        }
    }


    @FXML
    private Button TimeRemain;

    @FXML
    public Button ReturnToMenu1;











    public void ReturnToMenu1(ActionEvent event) {
        try {
            timeline.stop();
            for (int i = 0;i <=19; i++) {
                QuizController.checkStatus.set(i, false);
                QuizController.checkResult.set(i, false);
            }
            QuizController.fullTime = 100;
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


    @FXML
    public Button Submit;

    public void setSubmit(ActionEvent event) {
        try {
            timeline.stop();
            Stage thisstage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            thisstage.close();
            FXMLLoader quiz = new FXMLLoader(getClass().getResource("Result.fxml"));
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






    public static List<Boolean> checkStatus = new ArrayList<>();

    private void setStatus() {
        for (int i = 0; i < 20; i++) {
        checkStatus.add(false);
        }

    }

    private void loadResult() {
        for (int i = 0; i < 20; i++) {
            checkResult.add(false);
        }
    }


    @FXML
    private Button One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten
            , Eleven, Twelve, Thirteen, Fourteen, Fifteen, Sixteen, Seventeen, Eighteen, Nineteen, Twenty;




    @FXML
    private void Move1() {
        counter = 0;
        loadQuiz();
    }
    @FXML
    private void Move2() {
        counter = 1;
        loadQuiz();
    }
    @FXML
    private void Move3() {
        counter = 2;
        loadQuiz();
    }
    @FXML
    private void Move4() {
        counter = 3;
        loadQuiz();
    }
    @FXML
    private void Move5() {
        counter = 4;
        loadQuiz();
    }
    @FXML
    private void Move6() {
        counter = 5;
        loadQuiz();
    }
    @FXML
    private void Move7() {
        counter = 6;
        loadQuiz();
    }
    @FXML
    private void Move8() {
        counter = 7;
        loadQuiz();
    }
    @FXML
    private void Move9() {
        counter = 8;
        loadQuiz();
    }
    @FXML
    private void Move10() {
        counter = 9;
        loadQuiz();
    }
    @FXML
    private void Move11() {
        counter = 10;
        loadQuiz();
    }
    @FXML
    private void Move12() {
        counter = 11;
        loadQuiz();
    }
    @FXML
    private void Move13() {
        counter = 12;
        loadQuiz();
    }
    @FXML
    private void Move14() {
        counter = 13;
        loadQuiz();
    }
    @FXML
    private void Move15() {
        counter = 14;
        loadQuiz();
    }
    @FXML
    private void Move16() {
        counter = 15;
        loadQuiz();
    }
    @FXML
    private void Move17() {
        counter = 16;
        loadQuiz();
    }
    @FXML
    private void Move18() {
        counter = 17;
        loadQuiz();
    }
    @FXML
    private void Move19() {
        counter = 18;
        loadQuiz();
    }
    @FXML
    private void Move20() {
        counter = 19;
        loadQuiz();
    }



    private void fillColor() {
        if (counter == 0 && checkStatus.get(counter)) {
            One.setStyle("-fx-border-color:red");
        } else if (counter == 1 && checkStatus.get(counter)) {
            Two.setStyle("-fx-border-color:red");
        } else if (counter == 2 && checkStatus.get(counter)) {
            Three.setStyle("-fx-border-color:red");
        } else if (counter == 3 && checkStatus.get(counter)) {
            Four.setStyle("-fx-border-color:red");
        } else if (counter == 4 && checkStatus.get(counter)) {
            Five.setStyle("-fx-border-color:red");
        } else if (counter == 5 && checkStatus.get(counter)) {
            Six.setStyle("-fx-border-color:red");
        } else if (counter == 6 && checkStatus.get(counter)) {
            Seven.setStyle("-fx-border-color:red");
        } else if (counter == 7 && checkStatus.get(counter)) {
            Eight.setStyle("-fx-border-color:red");
        } else if (counter == 8 && checkStatus.get(counter)) {
            Nine.setStyle("-fx-border-color:red");
        } else if (counter == 9 && checkStatus.get(counter)) {
            Ten.setStyle("-fx-border-color:red");
        } else if (counter == 10 && checkStatus.get(counter)) {
            Eleven.setStyle("-fx-border-color:red");
        } else if (counter == 11 && checkStatus.get(counter)) {
            Twelve.setStyle("-fx-border-color:red");
        } else if (counter == 12 && checkStatus.get(counter)) {
            Thirteen.setStyle("-fx-border-color:red");
        } else if (counter == 13 && checkStatus.get(counter)) {
            Fourteen.setStyle("-fx-border-color:red");
        } else if (counter == 14 && checkStatus.get(counter)) {
            Fifteen.setStyle("-fx-border-color:red");
        } else if (counter == 15 && checkStatus.get(counter)) {
            Sixteen.setStyle("-fx-border-color:red");
        } else if (counter == 16 && checkStatus.get(counter)) {
            Seventeen.setStyle("-fx-border-color:red");
        } else if (counter == 17 && checkStatus.get(counter)) {
            Eighteen.setStyle("-fx-border-color:red");
        } else if (counter == 18 && checkStatus.get(counter)) {
            Nineteen.setStyle("-fx-border-color:red");
        } else if (counter == 19 && checkStatus.get(counter)) {
            Twenty.setStyle("-fx-border-color:red");
        }
    }

    @FXML
    public Button Retry1;

    @FXML
    private void Retry1(ActionEvent event) {
        try {
            timeline.stop();
            for (int i = 0;i <=19; i++) {
                QuizController.checkStatus.set(i, false);
                QuizController.checkResult.set(i, false);
            }
            QuizController.fullTime = 100;
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


    @FXML
    private AnchorPane QuestionPane;







}





