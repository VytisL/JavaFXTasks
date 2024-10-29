package com.example.javafx4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField textFieldOne;
    @FXML
    private TextField textFieldTwo;
    @FXML
    private Label outputLabel;

    @FXML
    private Button ButtonPlus;
    @FXML
    private Button ButtonMin;
    @FXML
    private Button ButtonMult;
    @FXML
    private Button ButtonDiv;

    private char operator;
    @FXML
    protected void plusButton(){
    operator = '+';
    //clearStyle();
   // ButtonPlus.setStyle("-fx-background-color: green");
    }
    @FXML
    protected void minusButton(){
        operator = '-';
       // clearStyle();
       // ButtonMin.setStyle("-fx-background-color: green");
    }
    @FXML
    protected void multButton(){
        operator = '*';
      //  clearStyle();
      //  ButtonMult.setStyle("-fx-background-color: green");
    }
    @FXML
    protected void divButton(){
        operator = '/';
     //   clearStyle();
      //  ButtonDiv.setStyle("-fx-background-color: green");
    }
 /*   protected void clearStyle(){
    ButtonPlus.setStyle("-fx-background-color: #FF0000");
    ButtonMin.setStyle("-fx-background-color: #FF0000");
    ButtonMult.setStyle("-fx-background-color: #FF0000");
    ButtonDiv.setStyle("-fx-background-color: #FF0000");
        // this is a bit inefficient as it changes all buttons instead of just the highlighted one but finding the highlighted one is too much of a bother
    }
*/

    @FXML
    protected void clearButton() {
        textFieldOne.setText(null);
        textFieldTwo.setText(null);
    }
    @FXML
    protected void enterButton() {

        //checks if errors were found
boolean flag = false;

        double a;
        double b;

        //check if entered numbers are valid
        try {
            a = Double.parseDouble(textFieldOne.getText());
        } catch (Exception e) {
            textFieldOne.setPromptText("Please enter a valid number");
            textFieldOne.setText(null);
            outputLabel.setText("Something went wrong!");
            flag = true;
        }
        try {
            b = Double.parseDouble(textFieldTwo.getText());
        } catch (Exception e1) {
            textFieldTwo.setPromptText("Please enter a valid number");
            textFieldTwo.setText(null);
            outputLabel.setText("Something went wrong!");
            flag = true;
        }
        if(operator != '+' && operator != '-' && operator != '/' && operator != '*') {
            flag = true;
            outputLabel.setText("No operator selected!");
        }


        if(flag == false){
        double ans;
        // initializing a and b again because it doesn't compile otherwise (even though it logically should)
        a = Double.parseDouble(textFieldOne.getText());
        b = Double.parseDouble(textFieldTwo.getText());
        switch(operator) {
            case '+':
                ans = a + b;
                outputLabel.setText(Double.toString(ans));
                break;
            case '-':
                ans = a-b;
                outputLabel.setText(Double.toString(ans));
                break;
            case '*':
                ans = a * b;
                outputLabel.setText(Double.toString(ans));
                break;
            case '/':
                if(b == 0){
                    outputLabel.setText("cannot divide by zero!");
                } else {
                    ans = a / b;
                    outputLabel.setText(Double.toString(ans));
                }

        }


        }
    }
}