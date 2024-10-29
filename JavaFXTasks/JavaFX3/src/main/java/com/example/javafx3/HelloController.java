package com.example.javafx3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ChoiceBox<String> colorChoice;
    @FXML
    private Label textLabel;

    HashMap<String, Color> colorStringHashMap = new HashMap<String, Color>();


    @FXML
    protected void mainButton() {
        String colN = colorChoice.getValue();
        textLabel.setText("this is " + colN + " huh, wow");

        Color col = colorStringHashMap.get(colN);
        String hexColor = String.format("#%02X%02X%02X",
                (int) (col.getRed() * 255),
                (int) (col.getGreen() * 255),
                (int) (col.getBlue() * 255));

        textLabel.setStyle("-fx-text-fill: " + hexColor + ";");
// I have no idea how the formatting works, I stole this part from ChatGPT
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        colorStringHashMap.put("red", Color.RED);
        colorStringHashMap.put("green", Color.GREEN);
        colorStringHashMap.put("blue", Color.BLUE);
        colorStringHashMap.put("beige", Color.BEIGE);
        colorChoice.getItems().addAll(colorStringHashMap.keySet());
    }
}