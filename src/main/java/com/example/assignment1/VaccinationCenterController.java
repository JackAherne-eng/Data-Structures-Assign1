package com.example.assignment1;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.*;
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
    public Tab tabApp;
    @FXML
    public Tab tabRec;
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
    public ListView<String> recordView;
    @FXML
    public ListView<String> appointmentView;
    @FXML
    private ListView<String> patientView;
    @FXML
    private ListView<String> boothView;
    @FXML
    private ListView<String> vcView;

    public void initialize() {
        pAccess.getItems().addAll("Yes", "No");
        aType.getItems().addAll("BioNTech & Pfizer", "Johnson & Johnson", "Moderna", "Oxford AstraZeneca", "Gamaleya (Sputnik V)");
        aTime.getItems().addAll("9:00-9:30", "9:30-10:00", "10:00-10:30", "10:30-11:00", "11:00-11:30", "11:30-12:00", "12:00-12:30", "12:30-13:00", "13:00-13:30", "13:30-14:00", "14:00-14:30", "14:30-15:00");
        tabApp.setDisable(true);
        tabRec.setDisable(true);
    }

    public void createVC(MouseEvent mouseEvent) {
        if (!Utilities.validEircode(vceircode.getText())) {
            return;
        }
        for (int i = VaccinationCenterApplication.VCList.size() - 1; i >= 0; i--) { //Checking The first 3 letters of your eircode
            if (VaccinationCenterApplication.VCList.get(i).getEircode().startsWith(vceircode.getText().substring(0, 3))) {
                return;
            }
        }
        VaccinationCenterInfo v;                   // Creates objects of type VaccinationCenterInfo
        vcView.getItems().addAll(vcname.getText()
                + ", " + vcaddress.getText()
                + ", " + vceircode.getText()
                + ", " + vcspace.getText());
        VaccinationCenterApplication.VCList.addElement(v = new VaccinationCenterInfo(vcname.getText(), vcaddress.getText(), vceircode.getText(), Integer.parseInt(vcspace.getText())));
        VCselect.getItems().clear();
        for (int i = VaccinationCenterApplication.VCList.size() - 1; i >= 0; i--) {
            VCselect.getItems().addAll(VaccinationCenterApplication.VCList.get(i).getName());
        }
    }

    //clearVC is working but for some reason can take ages (Sometimes 4 or 5 minutes) to actually execute.
    //Code hasn't changed but produces the right output.

    public void clearVC(MouseEvent mouseEvent) {
        VaccinationCenterApplication.VCList.clear();
        VaccinationCenterApplication.boothList.clear();
        VaccinationCenterApplication.AppointmentList.clear();
        VaccinationCenterApplication.patientList.clear();
        VaccinationCenterApplication.RecordList.clear();
        System.out.println(VaccinationCenterApplication.VCList.size());
        System.out.println(VaccinationCenterApplication.boothList.size());
        System.out.println(VaccinationCenterApplication.AppointmentList.size());
        System.out.println(VaccinationCenterApplication.patientList.size());
        System.out.println(VaccinationCenterApplication.RecordList.size());
    }

    public void createBooth(MouseEvent mouseEvent) {
        if (!Utilities.validIdentifier(indentifier.getText())) {
            return;
        }
        for (int i = VaccinationCenterApplication.boothList.size() - 1; i >= 0; i--) {
            if (VaccinationCenterApplication.boothList.get(i).getIdentifier().equals(indentifier.getText())) {
                return;
            }
        }
        Booth b;
        VaccinationCenterInfo v = VaccinationCenterApplication.VCList.search(vaccinationCenterInfo -> vaccinationCenterInfo.getName().equals(VCselect.getValue().toString()));
        System.out.println(v.getName());
        v.getListB().addElement(b = new Booth(indentifier.getText(), floorLevel.getText(), accessibility.getText()));
        VaccinationCenterApplication.boothList.addElement(b);
        boothSelect.getItems().clear();
        for (int i = VaccinationCenterApplication.boothList.size() - 1; i >= 0; i--) {
            boothSelect.getItems().addAll(VaccinationCenterApplication.boothList.get(i).getIdentifier());
        }
    }

    public void listBooth(MouseEvent mouseEvent) {
        boothView.getItems().clear();
        VaccinationCenterInfo v = VaccinationCenterApplication.VCList.search(vaccinationCenterInfo -> vaccinationCenterInfo.getName().equals(VCselect.getValue().toString()));
        for (int i = v.getListB().size() - 1; i >= 0; i--) {
            boothView.getItems().addAll(VCselect.getValue().toString()
                    + ": " + v.getListB().get(i).getIdentifier()
                    + ", " + v.getListB().get(i).getFloor()
                    + ", " + v.getListB().get(i).getAccessibility());
        }
    }

    public void createPatient(MouseEvent mouseEvent) {
        if (!Utilities.validPPS(pPPSN.getText())) {
            return;
        }
        if (!Utilities.validEmail(pEmail.getText())) {
            return;
        }
        Patient p;
        patientView.getItems().addAll(pName.getText()
                + ", " + pNumb.getText()
                + ", " + pDoB.getValue()
                + ", " + pEmail.getText()
                + ", " + pPPSN.getText()
                + ", " + pAccess.getValue().toString());
        VaccinationCenterApplication.patientList.addElement(p = new Patient(pName.getText(), Integer.parseInt(pNumb.getText()), pDoB.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), pEmail.getText(), pPPSN.getText(), pAccess.getValue().toString()));
        patientSelect.getItems().clear();
        for (int i = VaccinationCenterApplication.patientList.size() - 1; i >= 0; i--) {
            patientSelect.getItems().addAll(VaccinationCenterApplication.patientList.get(i).getName());
        }
        tabApp.setDisable(false);
        tabRec.setDisable(false);
    }

    public void createAppointment(MouseEvent mouseEvent) {
        Appointment a;
        Patient p = VaccinationCenterApplication.patientList.search(patient -> patient.getName().equals(patientSelect.getValue().toString()));
        Booth b = VaccinationCenterApplication.boothList.search(booth -> booth.getIdentifier().equals(boothSelect.getValue().toString()));
        p.getListA().addElement(a = new Appointment(aDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), aTime.getValue().toString(), aType.getValue().toString(), aBatchNum.getText(), aDetails.getText(), PPSText.getText()));
        b.getListA().addElement(a);
        appointmentView.getItems().addAll(aDate.getValue()
                + ", " + aTime.getValue().toString()
                + ", " + aType.getValue().toString()
                + ", " + aBatchNum.getText()
                + ", " + aDetails.getText()
                + ", " + PPSText.getText());
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
        for (int i = p.getListA().size() - 1; i >= 0; i--) {
            System.out.println(p.getListA().get(i).getDate());
        }
    }

    public void listApp(MouseEvent mouseEvent) {
        appointmentView.getItems().clear();
        Patient p = VaccinationCenterApplication.patientList.search(patient -> patient.getName().equals(patientSelect.getValue().toString()));
        for (int i = p.getListA().size() - 1; i >= 0; i--) {
            appointmentView.getItems().addAll(patientSelect.getValue().toString()
                    + ": " + p.getListA().get(i).getDate()
                    + ", " + p.getListA().get(i).getTime()
                    + ", " + p.getListA().get(i).getType()
                    + ", " + p.getListA().get(i).getbNum()
                    + ", " + p.getListA().get(i).getDetails()
                    + ", " + p.getListA().get(i).getPPS());
        }
    }


    public void submitApp(MouseEvent mouseEvent) {
        Record r;
        Patient p = VaccinationCenterApplication.patientList.search(patient -> patient.getName().equals(patientSelect.getValue().toString()));
        Appointment a = VaccinationCenterApplication.AppointmentList.search(appointment -> appointment.getPPS().equals(PPSText.getText()));
        p.getListRec().addElement(r = new Record(a.getPPS(), a.getDate(), a.getType()));
        VaccinationCenterApplication.RecordList.addElement(r);
        recordView.getItems().addAll(a.getPPS()
                + ", " + a.getDate()
                + ", " + a.getType());
        int selectedID = appointmentView.getSelectionModel().getSelectedIndex();
        appointmentView.getItems().remove(selectedID);
        p.getListA().remove(selectedID);
        for (int i = p.getListA().size() - 1; i >= 0; i--) {
            System.out.println(p.getListA().get(i).getDate());
        }
    }

    public void Save(MouseEvent mouseEvent) throws IOException {
        FileOutputStream save = new FileOutputStream("Database.dat");
        ObjectOutputStream objectout = new ObjectOutputStream(save);
        objectout.writeObject(VaccinationCenterApplication.patientList);
        objectout.writeObject(VaccinationCenterApplication.VCList);
        save.close();
    }

    public void Load(MouseEvent mouseEvent) throws IOException, ClassNotFoundException {
        FileInputStream load = new FileInputStream("Database.dat");
        ObjectInputStream objectout = new ObjectInputStream(load);
        VaccinationCenterApplication.patientList = (LinkedListCreation<Patient>) objectout.readObject();
        VaccinationCenterApplication.VCList = (LinkedListCreation<VaccinationCenterInfo>) objectout.readObject();
        load.close();
    }

    public void RefreshVC(MouseEvent mouseEvent) {
        vcView.getItems().clear();
        VCselect.getItems().clear();
        for (int i = VaccinationCenterApplication.VCList.size() - 1; i >= 0; i--) {
            vcView.getItems().addAll(VaccinationCenterApplication.VCList.get(i).getName()
                    + ": " + VaccinationCenterApplication.VCList.get(i).getAddress()
                    + ", " + VaccinationCenterApplication.VCList.get(i).getEircode()
                    + ", " + VaccinationCenterApplication.VCList.get(i).getP_space());
            VCselect.getItems().addAll(VaccinationCenterApplication.VCList.get(i).getName());
        }
        boothView.getItems().clear();
        boothSelect.getItems().clear();
        for (int i = VaccinationCenterApplication.VCList.size() - 1; i >= 0; i--) {
            for (int j = VaccinationCenterApplication.VCList.get(i).getListB().size() - 1; j >= 0; j--) { //All of my vaccination centers and grabbing all their booths
                boothView.getItems().addAll(VaccinationCenterApplication.VCList.get(i).getListB().get(j).getIdentifier()
                        + ", " + VaccinationCenterApplication.VCList.get(i).getListB().get(j).getFloor()
                        + ", " + VaccinationCenterApplication.VCList.get(i).getListB().get(j).getAccessibility());
                boothSelect.getItems().addAll(VaccinationCenterApplication.VCList.get(i).getListB().get(j).getIdentifier());
            }
        }
        patientView.getItems().clear();
        patientSelect.getItems().clear();
        for (int k = VaccinationCenterApplication.patientList.size() - 1; k >= 0; k--) {
            patientView.getItems().addAll(VaccinationCenterApplication.patientList.get(k).getName()
                    + ": " + VaccinationCenterApplication.patientList.get(k).getPhoneNum()
                    + ", " + VaccinationCenterApplication.patientList.get(k).getDoB()
                    + ", " + VaccinationCenterApplication.patientList.get(k).getEmail()
                    + ", " + VaccinationCenterApplication.patientList.get(k).getPPS()
                    + ", " + VaccinationCenterApplication.patientList.get(k).getAccRelate());
            patientSelect.getItems().addAll(VaccinationCenterApplication.patientList.get(k).getName());
        }
        appointmentView.getItems().clear();
        for (int k = VaccinationCenterApplication.patientList.size() - 1; k >= 0; k--) {
            for (int l = VaccinationCenterApplication.patientList.get(k).getListA().size() - 1; l >= 0; l--) {
                appointmentView.getItems().addAll(VaccinationCenterApplication.patientList.get(k).getListA().get(l).getDate()
                        + ", " + VaccinationCenterApplication.patientList.get(k).getListA().get(l).getTime()
                        + ", " + VaccinationCenterApplication.patientList.get(k).getListA().get(l).getType()
                        + ", " + VaccinationCenterApplication.patientList.get(k).getListA().get(l).getbNum()
                        + ": " + VaccinationCenterApplication.patientList.get(k).getListA().get(l).getDetails());

            }
        }

        recordView.getItems().clear();
        for (int k = VaccinationCenterApplication.patientList.size() - 1; k >= 0; k--) {
            for (int m = VaccinationCenterApplication.patientList.get(k).getListRec().size() - 1; m >= 0; m--){
                recordView.getItems().addAll(VaccinationCenterApplication.patientList.get(k).getListRec().get(m).getPPS()
                        + ", " + VaccinationCenterApplication.patientList.get(k).getListRec().get(m).getDate()
                        + ", " + VaccinationCenterApplication.patientList.get(k).getListRec().get(m).getType());
        }
        }
        tabApp.setDisable(false);
        tabRec.setDisable(false);
    }
}
