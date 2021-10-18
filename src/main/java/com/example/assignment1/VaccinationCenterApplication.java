package com.example.assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VaccinationCenterApplication extends Application {
    public static LinkedListCreation<VaccinationCenterInformation> VCList= new LinkedListCreation<>(); //NewLinkedList with the variable name VCList that only stores information from VaccinationCenterInformation
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VaccinationCenterApplication.class.getResource("VaccinationCenter.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Vaccination Center");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}