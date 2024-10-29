package com.example.javafx1;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class JavaFXOneController {

    Alert alert = new Alert(AlertType.NONE);



    @FXML
    protected void mainButton() {
        alert.setAlertType(AlertType.WARNING);
        alert.setContentText("Why would you do that");
        alert.show();
    }
}