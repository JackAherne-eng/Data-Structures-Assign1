package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.util.Comparator;

public class VaccinationCenterController {

    @FXML
    private ComboBox<Object> VCselect;
    @FXML
    private TextField vcname;
    @FXML
    private TextField vcaddress;
    @FXML
    private TextField vceircode;
    @FXML
    private TextField vcspace;
    @FXML
    private TextField indentifier;
    @FXML
    private TextField floorLevel;
    @FXML
    private TextField accessibility;
    @FXML
    private ListView<String> boothView;
    @FXML
    private ListView<String> vcView;

    public void createVC(MouseEvent mouseEvent) {
        VaccinationCenterInfo v;                   // extends objects of type VaccinationCenterInfo
        vcView.getItems().addAll(vcname.getText() + ", " + vcaddress.getText() + ", " + vceircode.getText() + ", " + vcspace.getText());
        VaccinationCenterApplication.VCList.addElement(v = new VaccinationCenterInfo(vcname.getText(), vcaddress.getText(), vceircode.getText(), Integer.parseInt(vcspace.getText())));
        VCselect.getItems().clear();
        for(int i = VaccinationCenterApplication.VCList.size() - 1; i >= 0; i--) {
            VCselect.getItems().addAll(VaccinationCenterApplication.VCList.get(i).getName());
        }
    }

    public void createBooth(MouseEvent mouseEvent) {
        Booth b;
        VaccinationCenterInfo v = VaccinationCenterApplication.VCList.search(vaccinationCenterInfo -> vaccinationCenterInfo.getName().equals(VCselect.getValue().toString()));
        System.out.println(v.getName());
        v.getListB().addElement(b = new Booth(indentifier.getText(), floorLevel.getText(), accessibility.getText()));
        VaccinationCenterApplication.boothList.addElement(b);
    }

    public void rvmBooth(MouseEvent mouseEvent) {
    }

    public void listBooth(MouseEvent mouseEvent) {
        boothView.getItems().clear();
        VaccinationCenterInfo v = VaccinationCenterApplication.VCList.search(vaccinationCenterInfo -> vaccinationCenterInfo.getName().equals(VCselect.getValue().toString()));
        for(int i = v.getListB().size() - 1; i >= 0; i --){
            boothView.getItems().addAll(VCselect.getValue().toString() + ": " + v.getListB().get(i).getIdentifier() + ", " + v.getListB().get(i).getFloor() + ", " + v.getListB().get(i).getAccessibility());
        }
    }
}
