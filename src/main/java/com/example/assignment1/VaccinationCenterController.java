package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class VaccinationCenterController {

    public TextField vcname;
    public TextField vcaddress;
    public TextField vceircode;
    public TextField vcspace;
    @FXML
    private ListView<String> ListView;

    public void AddButton(MouseEvent mouseEvent) {
        VaccinationCenterInfo v;
        ListView.getItems().addAll(vcname.getText() + ", " + vcaddress.getText() + ", " + vceircode.getText() + ", " + vcspace.getText());
        VaccinationCenterApplication.VCList.addElement(v = new VaccinationCenterInfo(vcname.getText(), vcaddress.getText(), vceircode.getText(), Integer.parseInt(vcspace.getText())));
        for(int i = 0; i < VaccinationCenterApplication.VCList.size(); i++) {
            System.out.println(VaccinationCenterApplication.VCList.get(i).getName());
        }
    }
}
