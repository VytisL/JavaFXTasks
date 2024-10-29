package com.example.javafx5;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;

    Alert alert = new Alert(Alert.AlertType.NONE);
    String userTemp;
    String passTemp;
    protected HashMap<String, String> users = new HashMap<String, String>();
    boolean flag;

    protected boolean test(){
        //check if username and password are valid
        boolean flag = false;

        try {
            userTemp = usernameField.getText();
        } catch (Exception E) {
            flag = true;
            usernameField.setPromptText("Enter a valid username");
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Invalid username");
            alert.showAndWait();
        }
        try {
            passTemp = passwordField.getText();
        } catch (Exception E1) {
            flag = true;
            passwordField.setPromptText("Enter a valid password");
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Invalid password");
            alert.showAndWait();
        }


        if(usernameField.getText() == null || usernameField.getText().isBlank()){
            flag = true;
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Invalid username");
            alert.showAndWait();
        }

        if(passwordField.getText() == null || passwordField.getText().isBlank()){
            flag = true;
            passwordField.setPromptText("Enter a valid password");
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setContentText("Invalid password");
            alert.showAndWait();
        }

            return flag;
        }
    @FXML
    protected void Register() {

        flag = test();


        //checks if user is already taken
        if(!flag) {
            userTemp = usernameField.getText();
            passTemp = passwordField.getText();
            if (users.containsKey(userTemp)) {
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Username already taken");
                alert.showAndWait();
            } else {
                users.put(userTemp, passTemp);
                usernameField.setText(null);
                passwordField.setText(null);
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setContentText("User registered!");
                alert.showAndWait();
            }
        }


    }

    @FXML
    protected void Login() {

        flag = test();

        if(!flag) {
            userTemp = usernameField.getText();
            passTemp = passwordField.getText();
            if(!users.containsKey(userTemp)){
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Username does not exist");
                alert.showAndWait();
            } else {
                if(!users.get(userTemp).equals(passTemp)){
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Password does not match");
                    alert.showAndWait();
                } else {
                    alert.setAlertType(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Success!");
                    alert.showAndWait();
                }
            }
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}