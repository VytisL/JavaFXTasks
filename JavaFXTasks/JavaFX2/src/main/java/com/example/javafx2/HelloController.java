package com.example.javafx2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label textLabel;
    @FXML
    private TextField textField;

    @FXML
    protected void mainButton() {
        textLabel.setText(textField.getText());
    }
}