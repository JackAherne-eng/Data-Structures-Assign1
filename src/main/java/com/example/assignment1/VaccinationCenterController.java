package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class VaccinationCenterController {

    @FXML
    public TextField aBatchNum;
    @FXML
    public TextField aDetails;
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
    private TextField pName;
    @FXML
    private TextField pNumb;
    @FXML
    private TextField pEmail;
    @FXML
    private TextField pPPSN;
    @FXML
    public Label PPSText;
    @FXML
    public DatePicker aDate;
    @FXML
    private DatePicker pDoB;
    @FXML
    public ChoiceBox<Object> aType;
    @FXML
    private ChoiceBox<Object> pAccess;
    @FXML
    public ChoiceBox<Object> aTime;
    @FXML
    private ComboBox<Object> VCselect;
    @FXML
    public ComboBox<Object> patientSelect;
    @FXML
    public ComboBox<Object> boothSelect;
    @FXML
    public ListView<String> appointmentView;
    @FXML
    private ListView<String> patientView;
    @FXML
    private ListView<String> boothView;
    @FXML
    private ListView<String> vcView;

    public void initialize(){
        pAccess.getItems().addAll("Yes" , "No");
        aType.getItems().addAll("BioNTech & Pfizer" , "Johnson & Johnson" , "Moderna" , "Oxford AstraZeneca" , "Gamaleya (Sputnik V)");
        aTime.getItems().addAll("9:00-9:30" , "9:30-10:00" , "10:00-10:30" , "10:30-11:00" , "11:00-11:30" , "11:30-12:00" , "12:00-12:30" , "12:30-13:00" , "13:00-13:30" , "13:30-14:00" , "14:00-14:30" , "14:30-15:00");
    }

    public void createVC(MouseEvent mouseEvent) {
        if(!Utilities.validEircode(vceircode.getText())){
            return;
        }
        for(int i = VaccinationCenterApplication.VCList.size() - 1; i >= 0; i--){ //Checking The first 3 letters of your eircode
            if(VaccinationCenterApplication.VCList.get(i).getEircode().startsWith(vceircode.getText().substring(0,3))){
                return;
            }
        }
        VaccinationCenterInfo v;                   // Creates objects of type VaccinationCenterInfo
        vcView.getItems().addAll(vcname.getText() + ", " + vcaddress.getText() + ", " + vceircode.getText() + ", " + vcspace.getText());
        VaccinationCenterApplication.VCList.addElement(v = new VaccinationCenterInfo(vcname.getText(), vcaddress.getText(), vceircode.getText(), Integer.parseInt(vcspace.getText())));
        VCselect.getItems().clear();
        for(int i = VaccinationCenterApplication.VCList.size() - 1; i >= 0; i--) {
            VCselect.getItems().addAll(VaccinationCenterApplication.VCList.get(i).getName());
        }
    }

    public void rvmVC(MouseEvent mouseEvent) {
    }

    public void clearVC(MouseEvent mouseEvent) {
        VaccinationCenterApplication.VCList.clear();
    }

    public void createBooth(MouseEvent mouseEvent) {
        if(!Utilities.validIdentifier(indentifier.getText())){
            return;
        }
        for(int i = VaccinationCenterApplication.boothList.size() - 1; i >= 0; i--){
            if(VaccinationCenterApplication.boothList.get(i).getIdentifier().equals(indentifier.getText())){
                return;
            }
        }
        Booth b;
        VaccinationCenterInfo v = VaccinationCenterApplication.VCList.search(vaccinationCenterInfo -> vaccinationCenterInfo.getName().equals(VCselect.getValue().toString()));
        System.out.println(v.getName());
        v.getListB().addElement(b = new Booth(indentifier.getText(), floorLevel.getText(), accessibility.getText()));
        VaccinationCenterApplication.boothList.addElement(b);
        boothSelect.getItems().clear();
        for(int i =VaccinationCenterApplication.boothList.size() - 1; i >= 0; i --){
            boothSelect.getItems().addAll(VaccinationCenterApplication.boothList.get(i).getIdentifier());
        }
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

    public void createPatient(MouseEvent mouseEvent) {
        if(!Utilities.validPPS(pPPSN.getText())){
            return;
        }
        if(!Utilities.validEmail(pEmail.getText())){
            return;
        }
        Patient p;
        patientView.getItems().addAll(pName.getText() + ", " + pNumb.getText() + ", " + pDoB.getValue() + ", " + pEmail.getText() + ", " + pPPSN.getText() + ", " + pAccess.getValue().toString());
        VaccinationCenterApplication.patientList.addElement(p = new Patient(pName.getText(), Integer.parseInt(pNumb.getText()), pDoB.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) , pEmail.getText(), pPPSN.getText(), pAccess.getValue().toString()));
        patientSelect.getItems().clear();
        for(int i = VaccinationCenterApplication.patientList.size() - 1; i >= 0; i --) {
            patientSelect.getItems().addAll(VaccinationCenterApplication.patientList.get(i).getName());
        }
    }

    public void createAppointment(MouseEvent mouseEvent) {

        Appointment a;
        Patient p = VaccinationCenterApplication.patientList.search(patient -> patient.getName().equals(patientSelect.getValue().toString()));
        Booth b = VaccinationCenterApplication.boothList.search(booth -> booth.getIdentifier().equals(boothSelect.getValue().toString()));
        p.getListA().addElement(a = new Appointment(aDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), aTime.getValue().toString(), aType.getValue().toString(), aBatchNum.getText(),aDetails.getText() , PPSText.getText()));
        b.getListA().addElement(a);
        appointmentView.getItems().addAll(aDate.getValue() + ", " + aTime.getValue().toString() + ", " + aType.getValue().toString() + ", " + aBatchNum.getText() + ", " +  aDetails.getText() + ", " + PPSText.getText());
        VaccinationCenterApplication.AppointmentList.addElement(a);


    }

    public void refreshPPS(MouseEvent mouseEvent) {
        Patient p = VaccinationCenterApplication.patientList.search(patient -> patient.getName().equals(patientSelect.getValue().toString()));
        PPSText.setText(p.getPPS());
    }

    public void rvmApp(MouseEvent mouseEvent) {
        Patient p = VaccinationCenterApplication.patientList.search(patient -> patient.getName().equals(patientSelect.getValue().toString()));
        int selectedID = appointmentView.getSelectionModel().getSelectedIndex();
        appointmentView.getItems().remove(selectedID);
        p.getListA().remove(selectedID);
        for(int i = p.getListA().size() -1; i >= 0; i--){
            System.out.println(p.getListA().get(i).getDate());
        }
    }

    public void listApp(MouseEvent mouseEvent) {
        appointmentView.getItems().clear();
        Patient p = VaccinationCenterApplication.patientList.search(patient -> patient.getName().equals(patientSelect.getValue().toString()));
        for(int i = p.getListA().size() - 1; i >= 0; i --){
            appointmentView.getItems().addAll(patientSelect.getValue().toString() + ": " + p.getListA().get(i).getDate() + ", " + p.getListA().get(i).getTime() + ", " + p.getListA().get(i).getType() + ", " + p.getListA().get(i).getbNum() + ", " + p.getListA().get(i).getDetails() + ", " + p.getListA().get(i).getPPS());
        }
    }
}
