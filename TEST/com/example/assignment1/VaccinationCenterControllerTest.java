package com.example.assignment1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.Label;

import static org.junit.jupiter.api.Assertions.*;

public class VaccinationCenterControllerTest<C> {

    @Test
    void createVC() {
        VaccinationCenterInfo vaccinationCenterinfo = new VaccinationCenterInfo("Oppenheimer", "13 Antelope", "Y35N7P2", 12);
        VaccinationCenterInfo vaccinationCenterInfo2 = new VaccinationCenterInfo("Hiroshima", "56 Dulberry", "YYYYYYY", 56);
        VaccinationCenterApplication.VCList.addElement(vaccinationCenterinfo);
        VaccinationCenterApplication.VCList.addElement(vaccinationCenterInfo2);
        VaccinationCenterApplication.VCList.addElement(vaccinationCenterInfo2);

        assertFalse(Utilities.validEircode("YYYYYYY"));

        assertFalse(VaccinationCenterApplication.VCList.size() == 1);
        assertFalse(VaccinationCenterApplication.VCList.size() == 2);
        assertTrue(VaccinationCenterApplication.VCList.size() == 3);
    }

    @Test
    void createBooth() {
        Booth booth = new Booth("A1", "First Floor", "Wheelchair");
        Booth booth1 = new Booth("BB2","Second Floor","Stairs");
        VaccinationCenterApplication.boothList.addElement(booth);
        VaccinationCenterApplication.boothList.addElement(booth1);

        assertFalse(Utilities.validIdentifier("BB2"));

        assertFalse(VaccinationCenterApplication.boothList.size() == 1);
        assertTrue(VaccinationCenterApplication.boothList.size() == 2);
        assertFalse(VaccinationCenterApplication.boothList.size() == 3);
    }

    @Test
    void createPatient() {
        Patient patient = new Patient("Harry",4,"04/12/2002","@.com","1234567K","Yes");           //Gave an error that my 9-digit phone number is too big. So it's' sadly reduced to 1
        Patient patient1 = new Patient("Sean", 9,"25/12/1969","Sean@live.ie","12345678P","No");   //Gave an error that my 9-digit phone number is too big. So it's' sadly reduced to 1
        VaccinationCenterApplication.patientList.addElement(patient);
        VaccinationCenterApplication.patientList.addElement(patient1);

        assertFalse(Utilities.validEmail("Sean@live.ie"));
        assertFalse(Utilities.validPPS("12345678P"));

        assertFalse(VaccinationCenterApplication.patientList.size() == 1);
        assertTrue(VaccinationCenterApplication.patientList.size() == 2);
        assertFalse(VaccinationCenterApplication.patientList.size() == 3);
    }

    @Test
    void createAppointment() {
        Appointment appointment = new Appointment("03/01/2022","9:00-9:30","Gamaleya (Sputnik V)","#T34","None","1234567K");
        Appointment appointment1 = new Appointment("03/02/2022","9:30-10:00","Gamaleya (Sputnik V)","#T34","None","1234567K");
        Appointment appointment2 = new Appointment("04/01/2022","9:30-10:00","Gamaleya (Sputnik V)","#T34","None","1234567K");
        Appointment appointment3 = new Appointment("04/02/2022","9:00-9:30","Gamaleya (Sputnik V)","#T34","None","1234567K");
        VaccinationCenterApplication.AppointmentList.addElement(appointment);
        VaccinationCenterApplication.AppointmentList.addElement(appointment1);
        VaccinationCenterApplication.AppointmentList.addElement(appointment2);
        VaccinationCenterApplication.AppointmentList.addElement(appointment3);

        assertFalse(VaccinationCenterApplication.AppointmentList.size() == 1);
        assertFalse(VaccinationCenterApplication.AppointmentList.size() == 2);
        assertFalse(VaccinationCenterApplication.AppointmentList.size() == 3);
        assertTrue(VaccinationCenterApplication.AppointmentList.size() == 4);
    }

    @Test
    void clearVC() {
        VaccinationCenterInfo vaccinationCenterinfo = new VaccinationCenterInfo("Oppenheimer", "13 Antelope", "Y35N7P2", 12);
        VaccinationCenterInfo vaccinationCenterInfo2 = new VaccinationCenterInfo("Hiroshima", "56 Dulberry", "YYYYYYY", 56);
        Booth booth = new Booth("A1", "First Floor", "Wheelchair");
        Booth booth1 = new Booth("BB2","Second Floor","Stairs");
        Patient patient = new Patient("Harry",4,"04/12/2002","@.com","1234567K","Yes");           //Gave an error that my 9-digit phone number is too big. So it's' sadly reduced to 1
        Patient patient1 = new Patient("Sean", 9,"25/12/1969","Sean@live.ie","1234567P","No");   //Gave an error that my 9-digit phone number is too big. So it's' sadly reduced to 1
        Appointment appointment = new Appointment("03/01/2022","9:00-9:30","Gamaleya (Sputnik V)","#T34","None","1234567K");
        Appointment appointment1 = new Appointment("03/02/2022","9:30-10:00","Gamaleya (Sputnik V)","#T34","None","1234567K");
        Appointment appointment2 = new Appointment("04/01/2022","9:30-10:00","Gamaleya (Sputnik V)","#T34","None","1234567K");
        Appointment appointment3 = new Appointment("04/02/2022","9:00-9:30","Gamaleya (Sputnik V)","#T34","None","1234567K");
        VaccinationCenterApplication.VCList.addElement(vaccinationCenterinfo);
        VaccinationCenterApplication.VCList.addElement(vaccinationCenterInfo2);
        VaccinationCenterApplication.VCList.addElement(vaccinationCenterInfo2);
        assertTrue(VaccinationCenterApplication.VCList.size() == 3);
        VaccinationCenterApplication.boothList.addElement(booth);
        VaccinationCenterApplication.boothList.addElement(booth1);
        assertTrue(VaccinationCenterApplication.boothList.size() == 2);
        VaccinationCenterApplication.patientList.addElement(patient);
        VaccinationCenterApplication.patientList.addElement(patient1);
        assertTrue(VaccinationCenterApplication.patientList.size() == 2);
        VaccinationCenterApplication.AppointmentList.addElement(appointment);
        VaccinationCenterApplication.AppointmentList.addElement(appointment1);
        VaccinationCenterApplication.AppointmentList.addElement(appointment2);
        VaccinationCenterApplication.AppointmentList.addElement(appointment3);
        assertTrue(VaccinationCenterApplication.AppointmentList.size() == 4);
        VaccinationCenterApplication.VCList.clear();
        VaccinationCenterApplication.boothList.clear();
        VaccinationCenterApplication.patientList.clear();
        VaccinationCenterApplication.AppointmentList.clear();

        assertFalse(VaccinationCenterApplication.VCList.size() == 3);
        assertTrue(VaccinationCenterApplication.VCList.size() == 0);
        assertFalse(VaccinationCenterApplication.boothList.size() == 2);
        assertTrue(VaccinationCenterApplication.boothList.size() == 0);
        assertFalse(VaccinationCenterApplication.patientList.size() == 2);
        assertTrue(VaccinationCenterApplication.patientList.size() == 0);
        assertFalse(VaccinationCenterApplication.AppointmentList.size() == 4);
        assertTrue(VaccinationCenterApplication.AppointmentList.size() == 0);
    }

    @Test
    void rvmApp() {
        Appointment appointment = new Appointment("03/01/2022","9:00-9:30","Gamaleya (Sputnik V)","#T34","None","1234567K");
        Appointment appointment1 = new Appointment("03/02/2022","9:30-10:00","Gamaleya (Sputnik V)","#T34","None","1234567K");
        Appointment appointment2 = new Appointment("04/01/2022","9:30-10:00","Gamaleya (Sputnik V)","#T34","None","1234567K");
        Appointment appointment3 = new Appointment("04/02/2022","9:00-9:30","Gamaleya (Sputnik V)","#T34","None","1234567K");
        VaccinationCenterApplication.AppointmentList.addElement(appointment);
        VaccinationCenterApplication.AppointmentList.addElement(appointment1);
        VaccinationCenterApplication.AppointmentList.addElement(appointment2);
        VaccinationCenterApplication.AppointmentList.addElement(appointment3);
        VaccinationCenterApplication.AppointmentList.remove(0);
        VaccinationCenterApplication.AppointmentList.remove(1);

        assertFalse(VaccinationCenterApplication.AppointmentList.size() == 1);
        assertTrue(VaccinationCenterApplication.AppointmentList.size() == 2);

    }
}