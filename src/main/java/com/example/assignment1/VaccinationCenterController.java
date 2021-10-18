package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class VaccinationCenterController {

    @FXML
    private ListView<String> ListView;

    @FXML
    private TextField Textbox;

    public void AddButton(MouseEvent mouseEvent) {
        ListView.getItems().addAll(Textbox.getText());

    }
}
