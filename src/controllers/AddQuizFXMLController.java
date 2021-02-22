/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author RSoloN
 */
public class AddQuizFXMLController implements Initializable {

    @FXML
    private TextField quizTitle;
    @FXML
    private TextArea question;
    @FXML
    private TextField option1;
    @FXML
    private TextField option2;
    @FXML
    private TextField option3;
    @FXML
    private TextField option4;
    @FXML
    private Button addNextQuestion;
    @FXML
    private Button submitQuiz;
    @FXML
    private RadioButton option1radio;
    @FXML
    private RadioButton option2radio;
    @FXML
    private RadioButton option3radio;
    @FXML
    private RadioButton option4radio;

    private ToggleGroup radioGroup;
    @FXML
    private Button setQuizTitleButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        radioButtonSetup();

        //Ce mode d'écriture en dessous peut remplacer
        //private void setQuizTitle (ActionEvent event){
        //System.out.println(".handle()");
        //   }
//        setQuizTitleButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("On a cliqué sur le bouton Enregistrer le titre");
//            }
//        });
        //Si on utilise ce mode d'écriture, on ne doit pas 
        //saisir dans On Action dans Scene Builder. 
    }

    private void radioButtonSetup() {
        radioGroup = new ToggleGroup();
        option1radio.setToggleGroup(radioGroup);
        option2radio.setToggleGroup(radioGroup);
        option3radio.setToggleGroup(radioGroup);
        option4radio.setToggleGroup(radioGroup);
    }

    @FXML
    private void setQuizTitle(ActionEvent event) {
//        System.out.println("On a cliqué sur le bouton Enregistrer le titre");
        String title = quizTitle.getText();
        if (title.trim().isEmpty()) {
//            Notifications noti = Notifications.create();
//            noti.text("Ecrire le titre du Quiz s'il vous plaît");
//            noti.title("Titre du Quiz");
//            noti.position(Pos.CENTER);
//            noti.hideAfter(Duration.millis(3000));
//            noti.showError();

            Notifications.create()
                    .darkStyle()
                    .text("Ecrire le titre du Quiz s'il vous plaît")
                    .title("Titre du Quiz")
                    .position(Pos.CENTER)
                    .hideAfter(Duration.millis(3000))
                    .showError();
//            System.out.println("Ecrire un titre");
        } else {
            quizTitle.setEditable(false);
            System.out.println("Titre enregistré...");
        }
    }

    private boolean validateFields() {
        String qu = this.question.getText();
        String op1 = this.option1.getText();
        String op2 = this.option2.getText();
        String op3 = this.option3.getText();
        String op4 = this.option4.getText();

        Toggle selectedRadio = radioGroup.getSelectedToggle();

        System.out.println(selectedRadio);

        if (qu.trim().isEmpty()
                || op1.trim().isEmpty()
                || op2.trim().isEmpty()
                || op3.trim().isEmpty()
                || op4.trim().isEmpty()) {
            Notifications.create()
                    .darkStyle()
                    .text("S'il vous plaît, remplir les champs de..."
                            + "\nQuestion"
                            + "\nOption1"
                            + "\nOption2"
                            + "\nOption3"
                            + "\nOption4")
                    .title("Question et option")
                    .position(Pos.CENTER)
                    .hideAfter(Duration.millis(3000))
                    .showError();
            return false;
        } else {
            if (selectedRadio == null) {
                Notifications.create()
                        .darkStyle()
                        .text("S'il vous plaît, sélectionne une réponse")
                        .title("Question et option")
                        .position(Pos.CENTER)
                        .hideAfter(Duration.millis(3000))
                        .showError();
                return false; 
            } else {
                //Enregistrer la question, les options et la réponse,puis
                //Next
                return true;
            }
        }
    }

    @FXML
    private void addNextQuestion(ActionEvent event) {
        boolean valid=validateFields();
        if(valid){
        //Enregistrer
            System.out.println("Enregistrer la question...");
        }
    }

    @FXML
    private void submitQuiz(ActionEvent event) {
    }
}
