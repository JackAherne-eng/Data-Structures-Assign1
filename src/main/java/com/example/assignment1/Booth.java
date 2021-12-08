package com.example.assignment1;

import java.io.Serializable;

public class Booth implements Serializable {

    private String identifier;
    private String floor;
    private String accessibility;
    private LinkedListCreation<Appointment> listA = new LinkedListCreation<>();

    public Booth(String identifier, String floor, String accessibility){

        this.identifier = identifier;

        this.floor = floor;

        this.accessibility = accessibility;


    }

    public LinkedListCreation<Appointment> getListA() {
        return listA;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getFloor() {
        return floor;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    public void setListA(LinkedListCreation<Appointment> listA) {
        this.listA = listA;
    }
}
